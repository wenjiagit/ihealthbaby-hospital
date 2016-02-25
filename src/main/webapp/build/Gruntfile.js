'use strict';
module.exports = function (grunt) {
    var bootstrap = "bootstrap-3.3.5";
    var AdminLTE = "AdminLTE-2.1.1";
    var FontAwesome = "Font-Awesome-4.3.0";
    require('matchdep').filterDev('grunt-*').forEach(grunt.loadNpmTasks);

    grunt.initConfig({
        watch: {
            // If any .less file changes in directory "build/less/" run the "less"-task.
            files: ['less/*.less', 'js/*.js'],
            tasks: ['less', 'autoprefixer', 'csscomb:dev',  'uglify']
        },
        clean: {
            options: {
                force: true
            },
            dist: '../lib'
        },
        less: {
            // Development not compressed
            dev: {
                options: {
                    compress: false,
                    strictMath: true,
                    outputSourceFiles: true
                },
                files: {
                    "../css/index.css": "less/index.less"
                }
            },
            dist: {
                options: {
                    compress: true,
                    strictMath: true,
                    outputSourceFiles: true,
                    sourceMap: true,
                    sourceMapURL: 'css/style.css.map',
                    sourceMapFilename: '../css/style.css.map'
                },
                files: {
                    "../css/index.min.css": 'less/index.less'
                }
            }
        },
        uglify: {
            dist: {
                options: {
                    report: "min",
                    sourceMap: true
                },
                files: {
                    '../js/main.min.js': 'js/main.js',
                    '../js/index.min.js': 'js/index.js',
                    '../js/alone-form.min.js': 'js/alone-form.js',
                    '../js/printThis.min.js': 'js/printThis.js',
                    '../lib/datetimepicker/js/jquery.datetimepicker.min.js': 'plugins/datetimepicker/jquery.datetimepicker.js',
                    '../lib/datetimepicker/js/jquery.datetimepicker.full.min.js': 'plugins/datetimepicker/jquery.datetimepicker.full.js',
                    '../lib/silviomoreto-bootstrap-select/js/bootstrap-select.min.js': 'plugins/silviomoreto-bootstrap-select/js/bootstrap-select.js'
                 }
            }
        },
        autoprefixer: {
            options: {
                browsers: [
                    "Android 2.3",
                    "Android >= 4",
                    "Chrome >= 20",
                    "Firefox >= 24",
                    "Explorer >= 8",
                    "iOS >= 6",
                    "Opera >= 12",
                    "Safari >= 6"
                ],
                map: false
            },
            dev: {
                src: '../css/index.css'
            },
            dist: {
                src: '../css/index.min.css'
            }
        },
        //cssmin: {
        //    options : {
        //        compatibility : 'ie8', //设置兼容模式
        //        noAdvanced : true //取消高级特性
        //    },
        //    minify: {
        //        expand: true,
        //        files: {
        //            '../lib/jquery-print-preview-plugin/print-preview.min.css': 'plugins/jquery-print-preview-plugin-master/src/css/print-preview.css'
        //        }
        //    }
        //},
        csscomb: {
            options: {
                config: 'less/.csscomb.json'
            },
            dev: {
                expand: true,
                cwd: '../css/',
                src: ['*.css', '!*.min.css'],
                dest: '../css/'
            },
            dist: {
                expand: true,
                files: {
                    '../lib/datetimepicker/css/jquery.datetimepicker.min.css': 'plugins/datetimepicker/jquery.datetimepicker.css',
                    '../lib/silviomoreto-bootstrap-select/css/bootstrap-select.min.css': 'plugins/silviomoreto-bootstrap-select/css/bootstrap-select.css'
                }
            }
        },
        //csslint: {
        //    options: {
        //        csslintrc: 'less/.csslintrc'
        //    },
        //    dev: [
        //        '../css/*.css'
        //    ]
        //},
        copy: {
            lib: {
                files: [
                    {expand: true, cwd: 'plugins/' + bootstrap + '/dist', src: ['**'], dest: '../lib/bootstrap'},
                    {expand: true, cwd: 'plugins/' + AdminLTE + '/dist', src: ['**'], dest: '../lib/AdminLTE'},
                    {
                        expand: true,
                        cwd: 'plugins/' + FontAwesome + '/css',
                        src: ['**'],
                        dest: '../lib/FontAwesome/css'
                    },
                    {
                        expand: true,
                        cwd: 'plugins/' + FontAwesome + '/fonts',
                        src: ['**'],
                        dest: '../lib/FontAwesome/fonts'
                    },
                    {expand: true, cwd: 'plugins/' + AdminLTE + '/plugins', src: ['**'], dest: '../lib/'},
                    {expand: true, cwd: 'plugins/html5shiv-3.7.3-pre/', src: ['**'], dest: '../lib/html5shiv'},
                    {expand: true, cwd: 'plugins/Respond-1.4.2/', src: ['**'], dest: '../lib/Respond'},
                    {expand: true, cwd: 'plugins/silviomoreto-bootstrap-select/dist', src: ['**'], dest: '../lib/silviomoreto-bootstrap-select'},
                    {expand: true, cwd: 'plugins/HubSpot-messenger/build', src: ['**'], dest: '../lib/HubSpot-messenger'},
                    {expand: true, cwd: 'plugins/HTML5-History-API', src: ['**'], dest: '../lib/HTML5-History-API'}
                ]
            }
        }
    });

    grunt.registerTask('default', ['watch']);
    grunt.registerTask('dist', ['copy', 'less','csscomb:dev', 'csscomb:dist',  'autoprefixer', 'uglify']);
};