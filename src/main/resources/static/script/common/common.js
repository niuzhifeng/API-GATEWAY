 var common = {
    ajax: function(url,param) {
        var val = {};
        $.ajax({
            type:"GET",
            async:false,
            cache:false,
            url: url,
            dataType: "json",
            data: param,
            error:function(data){
                alert(data.responseJSON.message);
            },
            success:function(data){
                val = data;
            }
        });
        return val;
    }
}