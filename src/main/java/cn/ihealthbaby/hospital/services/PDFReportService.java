package cn.ihealthbaby.hospital.services;

import httl.spi.codecs.json.JSON;
import httl.spi.codecs.json.JSONArray;
import httl.spi.codecs.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import cn.ihealthbaby.data.db.entity.AdviceDataDO;
import cn.ihealthbaby.hospital.httl.UtilsMethod;
import cn.ihealthbaby.hospital.model.PDFModel;

import com.isnowfox.util.DateTimeUtils;
import com.isnowfox.util.ZipUtils;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * @author qiang on 2015/9/15. jinliqiang@ihbaby.com
 */
@Service
public class PDFReportService {
	private static final int HEIGHT_OFFSET = 185;

	public ByteArrayOutputStream createPdf(PDFModel pdfModel)
			throws DocumentException, IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		// step 1
		Document document = new Document(PageSize.A4, 0, 0, 36, 36);
		// step 2
		PdfWriter writer = PdfWriter.getInstance(document, baos);
		// step 3
		document.open();
		// step 4
		try {
			createReportBaseInfo(document, pdfModel);
			createReportReportReadArea(writer.getDirectContentUnder(), pdfModel);
			drawReportTimeTable(document, writer.getDirectContentUnder(),
					pdfModel);
			if (pdfModel.getReportSettingsDO().getReportPrintView()) {
				createDataInfo(document, writer.getDirectContentUnder(),
						pdfModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		// step 5
		document.close();
		return baos;
	}

	public static BaseFont bfChinese;
	/**
	 * The number of locations on our time table.
	 */
	public static final int LOCATIONS = 32;
	/**
	 * The offset to the left of our time table.
	 */
	public static final float OFFSET_LEFT = 60;
	/**
	 * The width of our time table.
	 */
	public static final float WIDTH = 480;
	/**
	 * The offset from the bottom of our time table.
	 */
	public static final float OFFSET_BOTTOM = 460;
	/**
	 * The height of our time table
	 */
	public static final float HEIGHT = 165;

	/**
	 * The offset of the location bar next to our time table.
	 */
	public static final float OFFSET_LOCATION = 26;
	/**
	 * The width of the location bar next to our time table.
	 */
	public static final float WIDTH_LOCATION = 48;

	/**
	 * The height of a bar showing the movies at one specific location.
	 */
	public static final float HEIGHT_LOCATION = HEIGHT / LOCATIONS;
	/**
	 * The width of a time slot.
	 */
	public static String[] TIME = {"1’", "2’", "3’", "4’", "5’", "6’", "7’",
			"8’", "9’", "10’", "11’", "12’", "13’", "14’", "15’", "16’", "17’",
			"18’", "19’", "20’", "21’", "22’", "23’", "24’", "25’", "26’",
			"27’", "28’", "29’", "30’", "31’", "32’", "33’", "34’", "35’",
			"36’", "37’", "38’", "39’", "40’"};
	public static String[] BPM = {"60", "80", "100", "120", "140", "160",
			"180", "200", "220"};

	/**
	 * Draws the time table for a day at the film festival.
	 *
	 * @param directcontent
	 *            a canvas to which the time table has to be drawn.
	 */
	protected void drawReportTimeTable(Document doc,
			PdfContentByte directcontent, PDFModel pdfModel) throws Exception {
		int timelong = pdfModel.getAdviceDO().getTestTimeLong() / 300;
		if (pdfModel.getAdviceDO().getTestTimeLong() % 300 != 0) {
			timelong = (timelong + 1) * 5;
		} else {
			timelong = timelong * 5;
		}
		timelong = Math.max(timelong, 20);
		float llx, lly, urx, ury;
		directcontent.saveState();
		directcontent.setLineWidth(1.2f);
		directcontent.resetRGBColorFill();

		directcontent.setLineWidth(1);
		float y;
		for (int i = 1; i < LOCATIONS / 4; i++) {
			y = OFFSET_BOTTOM + (i * HEIGHT_LOCATION * 4) - 2;
			directcontent.setFontAndSize(bfChinese, 7);
			directcontent.setColorStroke(BaseColor.BLACK);
			directcontent.beginText();
			directcontent.showTextAligned(Element.ALIGN_LEFT, BPM[i - 1],
					OFFSET_LEFT - 15, y, 0);
			directcontent.endText();

		}
		int greenAreaHeight = 52;// 绿框初始高度
		int heightOffset = 0;// 绿框y轴偏移量
		String greenAreaLimit = pdfModel.getHospitalAdviceSettingDO()
				.getAlarmHeartrateLimit();
		if (StringUtils.isBlank(greenAreaLimit)) {
			greenAreaHeight = 52;
			heightOffset = 0;
		} else if (greenAreaLimit.equals("100-160")) {
			greenAreaHeight = 62;
			heightOffset = -10;
		} else if (greenAreaLimit.equals("110-160")) {
			greenAreaHeight = 52;

		} else if (greenAreaLimit.equals("120-160")) {
			greenAreaHeight = 42;
			heightOffset = 10;
		}
		directcontent.stroke();
		directcontent.setLineWidth(0);
		directcontent.rectangle(OFFSET_LEFT, OFFSET_BOTTOM + 72 + heightOffset,
				WIDTH, greenAreaHeight);
		directcontent.setRGBColorFill(230, 255, 232);
		directcontent.fill();
		directcontent.setColorStroke(BaseColor.BLACK);
		directcontent.restoreState();
		if (pdfModel.getReportSettingsDO().getDivisionY() == 5) {
			directcontent.saveState();
			for (int i = 1; i < LOCATIONS; i++) {
				y = OFFSET_BOTTOM + (i * HEIGHT_LOCATION);
				directcontent.setLineWidth(0.5f);
				for (int m = 0; m < WIDTH - 4; m = m + 4) {
					directcontent.moveTo(OFFSET_LEFT + m, y);
					directcontent.lineTo(OFFSET_LEFT + m + 2, y);
				}
				directcontent.setColorStroke(BaseColor.GRAY);
			}
			directcontent.stroke();
			directcontent.restoreState();
		}
		directcontent.saveState();
		for (int i = 1; i < LOCATIONS / 2; i++) {
			y = OFFSET_BOTTOM + (i * HEIGHT_LOCATION * 2);
			directcontent.setLineWidth(0.6f);
			directcontent.setColorStroke(BaseColor.BLACK);
			directcontent.moveTo(OFFSET_LEFT, y);
			directcontent.lineTo(OFFSET_LEFT + WIDTH, y);
		}
		directcontent.stroke();
		directcontent.restoreState();
		directcontent.saveState();
		directcontent.setLineWidth(1);
		llx = OFFSET_LEFT;
		lly = OFFSET_BOTTOM;
		urx = OFFSET_LEFT + WIDTH;
		ury = OFFSET_BOTTOM + HEIGHT;
		directcontent.moveTo(llx, lly);
		directcontent.lineTo(urx, lly);
		directcontent.lineTo(urx, ury);
		directcontent.lineTo(llx, ury);
		directcontent.lineTo(llx, lly);
		directcontent.closePath();
		directcontent.stroke();
		directcontent.restoreState();
		directcontent.saveState();
		float x;
		int divx = pdfModel.getReportSettingsDO().getDivisionX();
		if (divx == 0) {
			divx = 4;
		}
		int curXCount = timelong * divx;// 当前Y坐标有多少条
		float offset = WIDTH / curXCount;
		for (int i = 1; i < curXCount; i++) {
			x = OFFSET_LEFT + (i * offset);
			directcontent.setLineWidth(0.5f);
			directcontent.setColorStroke(BaseColor.GRAY);
			for (int m = 0; m < HEIGHT - 4; m = m + 4) {
				directcontent.moveTo(x, OFFSET_BOTTOM + m);
				directcontent.lineTo(x, OFFSET_BOTTOM + m + 2);
			}
			directcontent.stroke();
		}
		// 画每四条线加粗
		for (int i = 1; i < curXCount / divx; i++) {
			x = OFFSET_LEFT + (i * offset * divx);
			directcontent.setLineWidth(0.5f);
			directcontent.setColorStroke(BaseColor.BLACK);
			for (int m = 0; m < HEIGHT - 4; m = m + 4) {
				directcontent.moveTo(x, OFFSET_BOTTOM + m);
				directcontent.lineTo(x, OFFSET_BOTTOM + m + 2);
			}
			directcontent.setFontAndSize(bfChinese, 7);
			directcontent.beginText();
			directcontent.showTextAligned(Element.ALIGN_LEFT, TIME[i - 1], x,
					OFFSET_BOTTOM - 10, 0);
			directcontent.endText();
			directcontent.stroke();
		}
		directcontent.setFontAndSize(bfChinese, 7);
		directcontent.beginText();
		directcontent.showTextAligned(Element.ALIGN_LEFT, TIME[curXCount / divx
				- 1], OFFSET_LEFT + (curXCount / divx * offset * divx),
				OFFSET_BOTTOM - 10, 0);
		directcontent.endText();
		directcontent.restoreState();
		// 画曲线
		directcontent.saveState();
		directcontent.setLineWidth(.5f);
		String str = ZipUtils.decompression(pdfModel.getAdviceEcgDataDO()
				.getDataBlob());
		JSONObject obj = (JSONObject) JSON.parse(str);
		JSONObject data = (JSONObject) obj.get("data");
		JSONArray array = (JSONArray) data.get("heartRate");
		float dotx;
		float perDotLength = WIDTH / (timelong * 60 * 2);

		boolean isStart = false;

		directcontent.setColorStroke(BaseColor.BLACK);
		for (int i = 1; i < array.length() - 1; i++) {
			float point = array.getFloat(i, 100);
			float prepoint = array.getFloat(i - 1, 100);
			if (point > 50 && point <= 210 && Math.abs(prepoint - point) < 20) {
				dotx = OFFSET_LEFT + i * (perDotLength);

				if (isStart) {
					directcontent.lineTo(dotx, OFFSET_BOTTOM + point - 38);
				} else {
					directcontent.moveTo(dotx, OFFSET_BOTTOM + point - 38);
					isStart = true;
				}
			} else {
				isStart = false;
			}
		}
		directcontent.stroke();
		directcontent.restoreState();
		// 画胎动
		JSONArray fm = (JSONArray) data.get("fm");
		float perSLength = WIDTH / (timelong * 60);
		if (fm != null && fm.length() > 0) {

			directcontent.saveState();
			for (int i = 0; i < fm.length(); i++) {
				float ms = fm.getFloat(i, 0);
				float s = ms / 1000;
				if (i > 0) {
					float prems = fm.getFloat(i - 1, 0);
					float pres = prems / 1000;
					if (s - pres < 5) {
						continue;
					}
				}
				x = s * perSLength;
				directcontent.moveTo(x + OFFSET_LEFT, OFFSET_BOTTOM);
				directcontent.lineTo(x + OFFSET_LEFT, OFFSET_BOTTOM + 10);
				directcontent.moveTo(x + OFFSET_LEFT, OFFSET_BOTTOM + 9);
				directcontent.lineTo(x + OFFSET_LEFT - 2, OFFSET_BOTTOM + 5);
				directcontent.moveTo(x + OFFSET_LEFT, OFFSET_BOTTOM + 9);
				directcontent.lineTo(x + OFFSET_LEFT + 2, OFFSET_BOTTOM + 5);
			}
			directcontent.stroke();
			directcontent.restoreState();
		}
		JSONArray doctor = (JSONArray) data.get("doctor");
		if (doctor != null && doctor.length() > 0) {
			directcontent.saveState();
			for (int i = 0; i < doctor.length(); i++) {
				float ms = doctor.getFloat(i, 0);
				float s = ms / 1000;
				if (i > 0) {
					float prems = doctor.getFloat(i - 1, 0);
					float pres = prems / 1000;
					if (s - pres < 5) {
						continue;
					}
				}
				x = s * perSLength;
				directcontent.moveTo(x + OFFSET_LEFT, OFFSET_BOTTOM + 10);
				directcontent.lineTo(x + OFFSET_LEFT, OFFSET_BOTTOM);
				directcontent.moveTo(x + OFFSET_LEFT, OFFSET_BOTTOM + 1);
				directcontent.lineTo(x + OFFSET_LEFT - 2, OFFSET_BOTTOM + 5);
				directcontent.moveTo(x + OFFSET_LEFT, OFFSET_BOTTOM + 1);
				directcontent.lineTo(x + OFFSET_LEFT + 2, OFFSET_BOTTOM + 5);
			}
			directcontent.stroke();
			directcontent.restoreState();
		}
	}

	public void createReportBaseInfo(Document document, PDFModel pdfModel)
			throws Exception {
		PdfPTable table = new PdfPTable(new float[]{1, 1, 1.1f});
		table.setTotalWidth(WIDTH);
		PdfPCell cell;
		bfChinese = BaseFont.createFont("font/simsun.ttf", BaseFont.IDENTITY_H,
				BaseFont.NOT_EMBEDDED);
		// now we add a cell with rowspan 2
		Font font1 = new Font(bfChinese);
		font1.setSize(20);
		font1.setStyle(Font.BOLD);
		cell = new PdfPCell(new Phrase(pdfModel.getHospitalDO().getName(),
				font1));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setPadding(5);
		cell.setColspan(3);
		table.addCell(cell);
		Font font3 = new Font(bfChinese);
		font3.setSize(15);
		cell = new PdfPCell(new Phrase("胎心率电子监护报告单", font3));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setPadding(5);
		cell.setColspan(3);
		table.addCell(cell);
		Font font4 = new Font(bfChinese);
		font4.setSize(12);
		font4.setStyle(Font.BOLD);
		Long serviceNumber = 0L;
		if (pdfModel.getAdviceDO().getAdviceType() == 1) {
			if (pdfModel.getServiceDO() != null) {
				serviceNumber = pdfModel.getServiceDO().getServiceNumber();
			}
		} else {
			if (pdfModel.getServiceInsideDO() != null) {
				serviceNumber = pdfModel.getServiceInsideDO()
						.getServiceNumber();
			}
		}
		cell = new PdfPCell(new Phrase("监护单号："
				+ UtilsMethod.NumberFormat(serviceNumber), font4));
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setPadding(5);
		cell.setColspan(2);
		table.addCell(cell);
		cell = new PdfPCell(new Phrase("监护日期："
				+ DateTimeUtils.convertDateToString(pdfModel.getAdviceDO()
						.getTestTime(), "yyyy年MM月dd日"), font4));
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setPadding(5);
		table.addCell(cell);
		Font font5 = new Font(bfChinese);
		font5.setSize(12);
		cell = new PdfPCell(new Phrase("姓名：" + pdfModel.getUserDO().getName(),
				font5));
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setPadding(5);
		table.addCell(cell);
		cell = new PdfPCell(new Phrase("年龄：" + pdfModel.getAge(), font5));
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setPadding(5);
		table.addCell(cell);
		cell = new PdfPCell(new Phrase("咨询时间："
				+ DateTimeUtils.convertDateToString(pdfModel.getAskTime(),
						"MM-dd HH:mm"), font5));
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setPadding(5);
		table.addCell(cell);
		cell = new PdfPCell(new Phrase("咨询单号："
				+ UtilsMethod.NumberFormat(pdfModel.getAdviceDO()
						.getAdviceNumber()), font5));
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setPadding(5);
		table.addCell(cell);
		String caseNumber = "无";
		if (pdfModel.getAdviceDO().getAdviceType() == 1) {
			if (pdfModel.getServiceDO() != null) {
				caseNumber = pdfModel.getServiceDO().getCaseNumber();
			}
		} else {
			if (pdfModel.getServiceInsideDO() != null) {
				caseNumber = pdfModel.getServiceInsideDO().getCaseNumber();
			}
		}
		cell = new PdfPCell(new Phrase("就诊卡号：" + caseNumber, font5));
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setPadding(5);
		table.addCell(cell);
		cell = new PdfPCell(new Phrase("监测时间："
				+ DateTimeUtils.convertDateToString(pdfModel.getAdviceDO()
						.getTestTime(), "MM-dd HH:mm"), font5));
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setPadding(5);
		table.addCell(cell);
		cell = new PdfPCell(new Phrase("孕周："
				+ pdfModel.getAdviceDO().getGestationalWeeks(), font5));
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setPadding(5);
		cell.setColspan(2);
		table.addCell(cell);
		int min = pdfModel.getAdviceDO().getTestTimeLong() / 60;
		int sec = pdfModel.getAdviceDO().getTestTimeLong() % 60;
		cell = new PdfPCell(new Phrase("监测时长：" + min + "分" + sec + "秒", font5));
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setPadding(5);
		table.addCell(cell);
		document.add(table);
	}

	public void createDataInfo(Document document, PdfContentByte directcontent,
			PDFModel pdfModel) throws Exception {
		PdfPTable table = new PdfPTable(3);
		AdviceDataDO adviceDataDO = pdfModel.getAdviceDataDO();
		table.setTotalWidth(WIDTH);
		PdfPCell cell;
		Font font5 = new Font(bfChinese);
		font5.setStyle(Font.BOLD);
		font5.setSize(12);
		cell = new PdfPCell(new Phrase("胎心率基线："
				+ adviceDataDO.getBaselineRate() + "bpm", font5));
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setPadding(5);
		table.addCell(cell);
		cell = new PdfPCell(new Phrase("基线变异率："
				+ adviceDataDO.getBaselineVariability() + "bpm", font5));
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setPadding(5);
		table.addCell(cell);
		String s = "";
		if (adviceDataDO.getIsSin()) {
			s = "√";
		}
		cell = new PdfPCell(new Phrase("正弦波：" + s, font5));
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setPadding(5);
		table.addCell(cell);
		cell = new PdfPCell(new Phrase("加速次数：" + adviceDataDO.getSpeedupCount()
				+ "次", font5));
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setPadding(5);
		table.addCell(cell);
		cell = new PdfPCell(new Phrase("加速幅度：" + adviceDataDO.getSpeedupRange()
				+ "bpm", font5));
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setPadding(5);
		table.addCell(cell);
		cell = new PdfPCell(new Phrase("加速时间："
				+ adviceDataDO.getSpeedupDuration() + "秒", font5));
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setPadding(5);
		table.addCell(cell);
		cell = new PdfPCell(new Phrase("胎动计数："
				+ adviceDataDO.getFetalMoveCount() + "次", font5));
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setPadding(5);
		table.addCell(cell);
		cell = new PdfPCell(new Phrase("变异减速："
				+ adviceDataDO.getDecelerateCount() + "次", font5));
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setPadding(5);
		table.addCell(cell);
		cell = new PdfPCell(new Phrase("减速幅度："
				+ adviceDataDO.getDecelerateRange() + "bpm", font5));
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setPadding(5);
		table.addCell(cell);
		cell = new PdfPCell(new Phrase("减速时间："
				+ adviceDataDO.getDecelerateDuration() + "秒", font5));
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setPadding(5);
		table.addCell(cell);
		cell = new PdfPCell(new Phrase("晚期减速次数："
				+ adviceDataDO.getLateDecelerateCount() + "次", font5));
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setPadding(5);
		table.addCell(cell);
		cell = new PdfPCell(new Phrase());
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setPadding(5);
		table.addCell(cell);
		table.writeSelectedRows(0, -1, 0, -1, OFFSET_LEFT, OFFSET_BOTTOM - 20,
				directcontent);
	}

	public void createReportReportReadArea(PdfContentByte directcontent,
			PDFModel pdfModel) {
		directcontent.saveState();
		directcontent.setLineWidth(1f);
		directcontent.setColorStroke(BaseColor.BLACK);
		directcontent.setFontAndSize(bfChinese, 15);
		directcontent.beginText();
		directcontent.showTextAligned(Element.ALIGN_LEFT, "分析结果：", OFFSET_LEFT,
				OFFSET_BOTTOM - 150, 0);
		directcontent.endText();
		directcontent.stroke();
		directcontent.rectangle(OFFSET_LEFT, OFFSET_BOTTOM - 165 - HEIGHT,
				WIDTH, HEIGHT);
		directcontent.stroke();
		PdfPTable table = new PdfPTable(1);
		table.setTotalWidth(WIDTH);
		PdfPCell cell;
		Font font5 = new Font(bfChinese);
		font5.setStyle(Font.BOLD);
		font5.setSize(12);
		if (pdfModel.getAdviceReplyDO() != null) {
			cell = new PdfPCell(new Phrase(pdfModel.getAdviceReplyDO()
					.getReplyContext(), font5));
		} else {
			cell = new PdfPCell(new Phrase(""));
		}
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setPadding(5);
		table.addCell(cell);
		table.writeSelectedRows(0, -1, 0, -1, OFFSET_LEFT, OFFSET_BOTTOM - 166,
				directcontent);

		directcontent.setFontAndSize(bfChinese, 13);
		directcontent.beginText();
		directcontent.showTextAligned(Element.ALIGN_LEFT, "医生签名：", 440,
				OFFSET_BOTTOM - 185 - HEIGHT, 0);
		directcontent.endText();
		directcontent.stroke();
		directcontent.restoreState();

	}
}
