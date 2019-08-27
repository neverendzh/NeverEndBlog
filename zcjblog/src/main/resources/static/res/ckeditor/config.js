/**
 * @license Copyright (c) 2003-2018, CKSource - Frederico Knabben. All rights reserved.
 * For licensing, see https://ckeditor.com/legal/ckeditor-oss-license
 */

CKEDITOR.editorConfig = function (config) {


    config.toolbar = 'Full';
    config.language = 'zh-cn';
    config.uiColor = '#CCEAEE';
    config.height = "600px";
    config.removePlugins = 'elementspath';
    config.skin = 'moonocolor_v1.1';
    config.codeSnippet_theme = 'monokai_sublime',
        config.plugins.basePath = "/static/res/ckeditor/plugins/codesnippet/";
    //���ø߼�����ͼƬ���
    config.extraPlugins = 'uploadimage,image2,codesnippet',
        //��ͼƬ�ļ�·��
        config.uploadUrl = '/upload/file/img',
        //����ͼƬ��������ͼƬ��ʾ�����õ�ҳ��
        config.filebrowserBrowseUrl = '/upload/file/img',
        //    �ڡ� ͼ�񡱶Ի��򴰿��а��¡� �������������ťʱӦ�������ⲿ�ļ���������λ�á�
        config.filebrowserImageBrowseUrl = '/upload/file/img',
        //    �����ļ����صĽű���λ�á�������ã������ء�ѡ�����ʾ�ڡ� ���ӡ����� ͼ�� ���͡� Flash���Ի��򴰿��С�
        config.filebrowserUploadUrl = '/upload/file/img',
        //    �ڡ� ͼ�񡱶Ի��򴰿��д����ļ����صĽű���λ�á��ڡ� ͼ�񡱶Ի��򴰿��д����ļ����صĽű���λ�á�
        config.filebrowserImageUploadUrl = '/upload/file/img',
        config.stylesSet = [
            {name: 'Narrow image', type: 'widget', widget: 'image', attributes: {'class': 'image-narrow'}},
            {name: 'Wide image', type: 'widget', widget: 'image', attributes: {'class': 'image-wide'}}
        ];
    config.contentsCss = [CKEDITOR.basePath + 'contents.css'];    // Configure the Enhanced Image plugin to use classes instead of styles and to disable the
    // resizer (because image size is controlled by widget styles or the image takes maximum
    // 100% of the editor width).
    config.image2_alignClasses = ['image-align-left', 'image-align-center', 'image-align-right'];
    //������������ͼ�ߴ�
    config.image2_disableResizer = false;
    config.toolbar_Full = [
            {name: 'styles', items: ['Styles', 'Format', 'Font', 'FontSize']},
            {
                name: 'basicstyles',
                items: ['Bold', 'Italic', 'Underline', 'Strike', 'Subscript', 'Superscript', '-', 'RemoveFormat']
            },
            {
                name: 'paragraph',
                items: ['NumberedList', 'BulletedList', '-', 'Outdent', 'Indent', '-', 'Blockquote', 'CreateDiv',
                    '-', 'JustifyLeft', 'JustifyCenter', 'JustifyRight', 'JustifyBlock', '-', 'BidiLtr', 'BidiRtl']
            },
            {name: 'document', items: ['DocProps', 'Preview', '-', 'Templates']},
            {name: 'clipboard', items: ['Cut', 'Copy', 'Paste', 'PasteText', 'PasteFromWord', '-', 'Undo', 'Redo']},
            {name: 'editing', items: ['Find', 'Replace', '-', 'SelectAll', '-', 'SpellChecker', 'Scayt']},
            {name: 'links', items: ['Link', 'Unlink', 'Anchor']},
            {name: 'insert', items: ['Image', 'CodeSnippet', 'Table', 'HorizontalRule', 'Smiley', 'SpecialChar']},
            {name: 'colors', items: ['TextColor', 'BGColor']},
            {name: 'tools', items: ['Maximize']}
        ];
    var editor = CKEDITOR.instances.editor1;
    /**
     * �ϴ��ļ�֮��Ļص�������ʱ����Ҫ
     */
   /* editor.on('fileUploadResponse', function (evt) {
        // Prevent the default response handler.
        evt.stop();
        // debugger;
        // Get XHR and response.
        var data = evt.data,
            xhr = data.fileLoader.xhr,
            response = xhr.responseText;
         var datata  =  JSON.parse(response);
         console.log(datata);
        console.log(datata.error.message);
       /!* if (response[1]) {
            // An error occurred during upload.
            data.message = datata.fileName;
            evt.cancel();
        } else {*!/
            data.url = datata.url;
        // }
    });*/
};
