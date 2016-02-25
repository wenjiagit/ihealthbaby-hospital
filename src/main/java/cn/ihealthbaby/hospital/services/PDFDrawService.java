package cn.ihealthbaby.hospital.services;

import httl.spi.codecs.json.JSON;
import httl.spi.codecs.json.JSONArray;
import httl.spi.codecs.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Service;

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
public class PDFDrawService {
	private static final int HEIGHT_OFFSET = 185;

	public ByteArrayOutputStream createPdf(PDFModel pdfModel)
			throws DocumentException, IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		Document document = new Document(PageSize.A4.rotate());
		PdfWriter writer = PdfWriter.getInstance(document, baos);
		document.open();
		try {
			createBaseInfo(document, pdfModel);
			drawTimeTable(document, writer.getDirectContentUnder(), pdfModel);
		} catch (Exception e) {
			e.printStackTrace();
		}
		document.close();
		return baos;
	}

	public static BaseFont bfChinese;
	public static final int LOCATIONS = 32;
	public static final float OFFSET_LEFT = 130;
	public static final float WIDTH = 567;
	public static final float OFFSET_BOTTOM = 250;
	public static final float HEIGHT = 165;
	public static final float HEIGHT_LOCATION = HEIGHT / LOCATIONS;
	public static String[] TIME = {"1’", "2’", "3’", "4’", "5’", "6’", "7’",
			"8’", "9’", "10’", "11’", "12’", "13’", "14’", "15’", "16’", "17’",
			"18’", "19’", "20’", "21’", "22’", "23’", "24’", "25’", "26’",
			"27’", "28’", "29’", "30’", "31’", "32’", "33’", "34’", "35’",
			"36’", "37’", "38’", "39’", "40’"};
	public static String[] BPM = {"60", "80", "100", "120", "140", "160",
			"180", "200"};
	/**
	 * Draws the time table for a day at the film festival.
	 * 
	 * @param directcontent
	 *            a canvas to which the time table has to be drawn.
	 */
	protected void drawTimeTable(Document doc, PdfContentByte directcontent,
			PDFModel pdfModel) throws Exception {
		int timelong = pdfModel.getAdviceDO().getTestTimeLong() / 60;
		if (pdfModel.getAdviceDO().getTestTimeLong() % 60 != 0) {
			timelong = timelong + 1;
		}
		int paperSpeed = pdfModel.getReportSettingsDO().getPaperspeed();
		int divX = pdfModel.getReportSettingsDO().getDivisionX();
		if (divX == 0) {
			divX = 4;
		}
		int YlineCount = (20 / paperSpeed) * divX;
		float llx, lly, urx, ury;
		double drawTimes = Math
				.ceil((Double.parseDouble(timelong + "") * paperSpeed) / 20);
		int count = 0;// 定义分页次数
		for (int time = 0; time < drawTimes; time++) {

			int initOffset = 0;// 定义分页起始偏移量;
			if (time > 0 && time % 2 == 0) {
				doc.newPage();
				count++;
			}
			initOffset = time - count * 2;
			directcontent.saveState();
			directcontent.setLineWidth(1.2f);
			directcontent.resetRGBColorFill();

			directcontent.setLineWidth(1);
			// 画左边角标
			float y;
			for (int i = 1; i < LOCATIONS / 4; i++) {
				y = OFFSET_BOTTOM + (i * HEIGHT_LOCATION * 4) - 2;
				directcontent.newPath();
				directcontent.setFontAndSize(bfChinese, 7);
				directcontent.setColorStroke(BaseColor.BLACK);
				directcontent.beginText();
				directcontent.showTextAligned(Element.ALIGN_LEFT, BPM[i - 1],
						OFFSET_LEFT - 15, y - (initOffset * HEIGHT_OFFSET), 0);
				directcontent.endText();
				directcontent.stroke();
				directcontent.closePath();
			}
			// 画绿色矩形
			int greenAreaHeight = 52;// 绿框初始高度
			int heightOffset = 0;// 绿框y轴偏移量
			String greenAreaLimit = pdfModel.getHospitalAdviceSettingDO()
					.getAlarmHeartrateLimit();
			if (org.apache.commons.lang3.StringUtils.isBlank(greenAreaLimit)) {
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

			directcontent.newPath();
			directcontent.setLineWidth(0);
			directcontent.rectangle(OFFSET_LEFT, OFFSET_BOTTOM + 72
					- (initOffset * HEIGHT_OFFSET) + heightOffset, WIDTH,
					greenAreaHeight);
			directcontent.setRGBColorFill(200, 247, 212);
			directcontent.fill();
			directcontent.closePath();
			directcontent.setColorStroke(BaseColor.BLACK);
			directcontent.restoreState();
			// 画横虚线
			if (pdfModel.getReportSettingsDO().getDivisionY() == 5) {
				directcontent.saveState();
				for (int i = 1; i < LOCATIONS; i++) {
					y = OFFSET_BOTTOM + (i * HEIGHT_LOCATION);
					directcontent.setLineWidth(0.5f);
					directcontent.setColorStroke(BaseColor.GRAY);
					for (int m = 0; m < WIDTH - 4; m = m + 4) {
						directcontent.moveTo(OFFSET_LEFT + m, y
								- (initOffset * HEIGHT_OFFSET));
						directcontent.lineTo(OFFSET_LEFT + m + 2, y
								- (initOffset * HEIGHT_OFFSET));
					}
				}
				directcontent.stroke();
				directcontent.restoreState();
			}
			// 画横实线
			directcontent.saveState();
			for (int i = 1; i < LOCATIONS / 2; i++) {
				y = OFFSET_BOTTOM + (i * HEIGHT_LOCATION * 2);
				directcontent.setLineWidth(0.5f);
				directcontent.setColorStroke(BaseColor.BLACK);
				directcontent.moveTo(OFFSET_LEFT, y
						- (initOffset * HEIGHT_OFFSET));
				directcontent.lineTo(OFFSET_LEFT + WIDTH, y
						- (initOffset * HEIGHT_OFFSET));
				directcontent.stroke();

			}
			directcontent.restoreState();
			// 画边界
			directcontent.saveState();
			directcontent.setLineWidth(1);
			llx = OFFSET_LEFT;
			lly = OFFSET_BOTTOM - (initOffset * HEIGHT_OFFSET);
			urx = OFFSET_LEFT + WIDTH;
			ury = OFFSET_BOTTOM + HEIGHT - (initOffset * HEIGHT_OFFSET);
			directcontent.moveTo(llx, lly);
			directcontent.lineTo(urx, lly);
			directcontent.lineTo(urx, ury);
			directcontent.lineTo(llx, ury);
			directcontent.lineTo(llx, lly);
			directcontent.closePath();
			directcontent.stroke();
			directcontent.restoreState();
			// 画竖线
			directcontent.saveState();
			float x;

			int curXCount = YlineCount;// 当前Y坐标有多少条
			float offset = WIDTH / curXCount;
			for (int i = 1; i < curXCount; i++) {
				x = OFFSET_LEFT + (i * offset);
				for (int m = 0; m < HEIGHT - 4; m = m + 4) {
					directcontent.moveTo(x, OFFSET_BOTTOM + m
							- (initOffset * HEIGHT_OFFSET));
					directcontent.lineTo(x, OFFSET_BOTTOM + m + 2
							- (initOffset * HEIGHT_OFFSET));
				}
				directcontent.setLineWidth(0.4f);
				directcontent.setColorStroke(BaseColor.GRAY);
				directcontent.stroke();
			}
			for (int i = 1; i < curXCount / divX; i++) {
				x = OFFSET_LEFT + (i * offset * divX);
				directcontent.setLineWidth(0.5f);
				directcontent.setColorStroke(BaseColor.BLACK);
				for (int m = 0; m < HEIGHT - 4; m = m + 4) {
					directcontent.moveTo(x, OFFSET_BOTTOM + m
							- (initOffset * HEIGHT_OFFSET));
					directcontent.lineTo(x, OFFSET_BOTTOM + m + 2
							- (initOffset * HEIGHT_OFFSET));
				}
				directcontent.setFontAndSize(bfChinese, 7);
				directcontent.beginText();
				directcontent.showTextAligned(Element.ALIGN_LEFT, TIME[i - 1
						+ time * (curXCount / divX)], x, OFFSET_BOTTOM - 10
						- (initOffset * HEIGHT_OFFSET), 0);
				directcontent.endText();
				directcontent.stroke();
			}
			directcontent.setFontAndSize(bfChinese, 7);
			directcontent.beginText();
			directcontent.showTextAligned(Element.ALIGN_LEFT, TIME[curXCount
					/ divX - 1 + time * (curXCount / divX)], OFFSET_LEFT
					+ (curXCount / divX * offset * divX), OFFSET_BOTTOM - 10
					- (initOffset * HEIGHT_OFFSET), 0);
			directcontent.endText();
			directcontent.restoreState();
			directcontent.saveState();
			directcontent.setLineWidth(.5f);
			String str = ZipUtils.decompression(pdfModel.getAdviceEcgDataDO()
					.getDataBlob());
			JSONObject obj = (JSONObject) JSON.parse(str);
			JSONObject data = (JSONObject) obj.get("data");
			JSONArray array = (JSONArray) data.get("heartRate");
			boolean isStart = false;
			float dotx;
			int linedotCount = 20 / paperSpeed * 120;
			float perDotLength = WIDTH / linedotCount;
			int usedDotCount = time * linedotCount;
			directcontent.setColorStroke(BaseColor.BLACK);
			int forCount = Math.min(array.length() - time * linedotCount,
					linedotCount);
			for (int i = 1; i < forCount - 1; i++) {

				float point = array.getFloat(usedDotCount + i, 100);
				float prepoint = array.getFloat(usedDotCount + i - 1, 100);
				if (point > 40 && point <= 220
						&& Math.abs(prepoint - point) < 20) {
					dotx = OFFSET_LEFT + i * (perDotLength);

					if (isStart) {
						directcontent.lineTo(dotx, OFFSET_BOTTOM + point - 38
								- (initOffset * HEIGHT_OFFSET));
					} else {
						directcontent.moveTo(dotx, OFFSET_BOTTOM + point - 38
								- (initOffset * HEIGHT_OFFSET));
						isStart = true;
					}
				} else {
					isStart = false;
				}
			}
			directcontent.stroke();
			directcontent.restoreState();
			JSONArray fm = (JSONArray) data.get("fm");
			int Sofline = (20 / paperSpeed) * 60;
			if (fm != null && fm.length() > 0) {
				directcontent.saveState();

				for (int i = 0; i < fm.length(); i++) {

					float ms = fm.getFloat(i, 0);
					float s = ms / 1000;
					if (s - time * Sofline < 0) {
						continue;
					}
					if (i > 0) {
						float prems = fm.getFloat(i - 1, 0);
						float pres = prems / 1000;
						if (s - pres < 5) {
							continue;
						}
					}
					x = s * 2 * perDotLength + OFFSET_LEFT - time * WIDTH;

					directcontent.moveTo(x, OFFSET_BOTTOM
							- (initOffset * HEIGHT_OFFSET));
					directcontent.lineTo(x, OFFSET_BOTTOM
							- (initOffset * HEIGHT_OFFSET) + 10);
					directcontent.moveTo(x, OFFSET_BOTTOM
							- (initOffset * HEIGHT_OFFSET) + 9);
					directcontent.lineTo(x - 2, OFFSET_BOTTOM
							- (initOffset * HEIGHT_OFFSET) + 5);
					directcontent.moveTo(x, OFFSET_BOTTOM
							- (initOffset * HEIGHT_OFFSET) + 9);
					directcontent.lineTo(x + 2, OFFSET_BOTTOM
							- (initOffset * HEIGHT_OFFSET) + 5);
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
					if (s - time * Sofline < 0) {
						continue;
					}
					if (i > 0) {
						float prems = doctor.getFloat(i - 1, 0);
						float pres = prems / 1000;
						if (s - pres < 5) {
							continue;
						}
					}
					x = s * 2 * perDotLength + OFFSET_LEFT - time * WIDTH;
					directcontent.moveTo(x, OFFSET_BOTTOM
							- (initOffset * HEIGHT_OFFSET) + 10);
					directcontent.lineTo(x, OFFSET_BOTTOM
							- (initOffset * HEIGHT_OFFSET));
					directcontent.moveTo(x, OFFSET_BOTTOM
							- (initOffset * HEIGHT_OFFSET) + 1);
					directcontent.lineTo(x - 2, OFFSET_BOTTOM
							- (initOffset * HEIGHT_OFFSET) + 5);
					directcontent.moveTo(x, OFFSET_BOTTOM
							- (initOffset * HEIGHT_OFFSET) + 1);
					directcontent.lineTo(x + 2, OFFSET_BOTTOM
							- (initOffset * HEIGHT_OFFSET) + 5);
				}
				directcontent.stroke();
				directcontent.restoreState();
			}
		}
	}
	public void createBaseInfo(Document document, PDFModel pdfModel)
			throws Exception {
		PdfPTable table = new PdfPTable(new float[]{1, 1, 1.1f});
		table.setTotalWidth(WIDTH);
		PdfPCell cell;
		bfChinese = BaseFont.createFont("font/simsun.ttf", BaseFont.IDENTITY_H,
				BaseFont.NOT_EMBEDDED);
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
		cell = new PdfPCell(new Phrase("胎心率电子监护精细图", font3));
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
}
