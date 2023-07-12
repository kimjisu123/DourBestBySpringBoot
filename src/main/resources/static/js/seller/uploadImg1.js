function readURL(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();
        reader.onload = function(e) {
            $('#imagePreview1').css('background-image', 'url('+e.target.result +')');
            $('#imagePreview1').hide();
            $('#imagePreview1').fadeIn(650);
        }
        reader.readAsDataURL(input.files[0]);
    }
}
$("#imageUpload1").change(function() {
    readURL(this);
});

// $(document).ready(function(){
//     $('input[type="radio"]').click(function(){
//         var inputValue = $(this).attr("value");
//         var targetBox = $("." + inputValue);
//         $(".box").not(targetBox).hide();
//         $(targetBox).show();
//     });
// });

$('#summary').keyup(function (e){
    var content = $(this).val();
    $('#count').html(100 - content.length);
})

function limit(obj,cnt) {
    if (obj.value.length>cnt) obj.value = obj.value.substring(0, cnt);
    document.getElementById('memoLength').innerHTML = cnt-obj.value.length;
};


$('#summernote').summernote({
    toolbar: [
        // [groupName, [list of button]]
        ['fontname', ['fontname']],
        ['fontsize', ['fontsize']],
        ['style', ['bold', 'italic', 'underline','strikethrough', 'clear']],
        ['color', ['forecolor','color']],
        ['table', ['table']],
        ['para', ['ul', 'ol', 'paragraph']],
        ['height', ['height']],
        ['insert',['picture','link','video']],
    ],
    fontNames: ['Arial', 'Arial Black', 'Comic Sans MS', 'Courier New','맑은 고딕','궁서','굴림체','굴림','돋움체','바탕체'],
    fontSizes: ['8','9','10','11','12','14','16','18','20','22','24','28','30','36','50','72'],
    height: 300,
    width: 800,
    placeholder: '내용을 입력해주세요',
    callbacks: {	//여기 부분이 이미지를 첨부하는 부분
        onImageUpload : function(files) {
            uploadSummernoteImageFile(files[0],this);
        },
        onPaste: function (e) {
            var clipboardData = e.originalEvent.clipboardData;
            if (clipboardData && clipboardData.items && clipboardData.items.length) {
                var item = clipboardData.items[0];
                if (item.kind === 'file' && item.type.indexOf('image/') !== -1) {
                    e.preventDefault();
                }
            }
        }
    }
});

/* 이미지 파일 업로드 */
function uploadSummernoteImageFile(file, editor) {
    data = new FormData();
    data.append("file", file);
    $.ajax({
        data : data,
        type : "POST",
        url : "/submit/summernoteImg",
        contentType : false,
        processData : false,
        success : function(data) {
            //항상 업로드된 파일의 url이 있어야 한다.
            let originName = data.originName;
            let savedName = data.savedName;
            let oriName = document.getElementById('oriName').value;
            let saveName = document.getElementById('saveName').value;

            document.getElementById('oriName').value = oriName + originName + '&';
            document.getElementById('saveName').value = saveName + savedName + '&';
            $(editor).summernote('insertImage', data.url);
        }
    });
}



// $('.inputimg').on('change', function() {
//     $input = this;
//     if($input.files.length > 0) {
//         fileReader = new FileReader();
//         fileReader.onload = function (data) {
//             $input.parentNode.querySelector('.image-preview').setAttribute('src', data.target.result);
//             // $('.image-preview').attr('src', data.target.result);
//         }
//         fileReader.readAsDataURL($input.files[0]);
//         $input.parentNode.querySelector('.image-button').style.display = 'none';
//         $input.parentNode.querySelector('.image-preview').style.display = 'block';
//         $input.parentNode.querySelector('.change-image').style.display = 'block';
//     }
// });
//
// $('.change-image').on('click', function() {
//     $control = this;
//     $('#imageInput').val('');
//     // $preview = $('.image-preview');
//     $control.parentNode.querySelector('.image-preview').setAttribute('src', '');
//     // $preview.attr('src', '');
//     $control.parentNode.querySelector('.image-preview').style.display = 'none';
//     $control.parentNode.querySelector('.change-image').style.display = 'none';
// /*    $preview.css('display', 'none');
//     $control.css('display', 'none');*/
//     $control.parentNode.querySelector('.image-button').style.display = 'block';
//     // $('.image-button').css('display', 'block');
// });

// $("#file").on('change',function(){
//     var fileName = $("#file").val();
//     $(".upload-name").val(fileName);
// });