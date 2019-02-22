$.ajax({
    url: '/url',
    type: 'post',
    data: {id: id},
    dataType: 'json',
    success: function (result, textStatus, jqXHR) {
        jqXHR.getResponseHeader("csrf");
    }
});