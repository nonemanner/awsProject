var main = {
    init : function () {
        var _this = this;
        $('#btn-save').on('click', function() {
            _this.save();
        });

        $('#btn-update').on('click', function() {
            _this.update();
        });

        $('#btn-delete').on('click', function() {
            _this.delete();
        });

        $('#btn-add').on('click', function() {
            _this.add();
        });

        $('.exts-delete').on('click', function() {
            var id = $(this).attr('name');
            _this.deleteExts(id);
        });

        $("input[name='extsDefault']").each(function(e){
            var useYn = $(this).val();
            if(useYn === 'Y'){
                $(this).prop("checked", true);
            } else{
                $(this).prop("checked", false);
            }

        });

        $("input[name='extsDefault']").change(function(){

            var id = $(this).attr('id');
            var strArr = id.split('-');

            if($(this).is(":checked")){
                var useYn = 'Y';
                _this.updateExts(strArr[1], useYn);
            }else{
                var useYn = 'N';
                _this.updateExts(strArr[1], useYn);
            }
        });

    },
    save : function () {
        var data = {
            title: $('#title').val(),
            author: $('#author').val(),
            content: $('#content').val()
        };

        $.ajax({
           type: 'POST',
           url: '/api/v1/posts',
           dataType: 'json',
           contentType: 'application/json; charset=utf-8',
           data: JSON.stringify(data)
        }).done(function() {
            alert('글이 등록되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },

    update : function () {
        var data = {
            title: $('#title').val(),
            content: $('#content').val()
        };

        var id = $('#id').val();

        $.ajax({
            type: 'PUT',
            url: '/api/v1/posts/'+id,
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function () {
            alert('글이 수정되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });

    },

    delete : function () {
        var id = $('#id').val();

        $.ajax({
            type: 'DELETE',
            url: '/api/v1/posts/'+id,
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
        }).done(function () {
            alert('글이 삭제되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });

    },

    add : function () {
        var data = {
            name: $('#extName').val(),
            customYn : 'Y'
        };

        $.ajax({
            type: 'POST',
            url: '/api/v1/exts',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('추가되었습니다.');
            window.location.href = '/exts';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },

    deleteExts : function (id) {

        $.ajax({
            type: 'DELETE',
            url: '/api/v1/exts/'+id,
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
        }).done(function () {
            alert('삭제되었습니다.');
            window.location.href = '/exts';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });

    },

    updateExts : function (id, useYn) {
        var data = {
            useYn: useYn
        };

        $.ajax({
            type: 'PUT',
            url: '/api/v1/exts/'+id,
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function () {
            //window.location.href = '/exts';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    }
};

main.init();