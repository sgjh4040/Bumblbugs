 $(function () {
            $(".outbutton").on("click", function () {
                var input = $(this).prev().text();
                
                $(this).parent().parent().next().toggle();
                $(this).parent().parent().toggle();
            });
            $(".inbutton").on("click", function () {
                var input = $(this).prev().val();
                
                $(this).parent().parent().prev().toggle();
                $(this).parent().parent().toggle();
            });
            $("#update-address").on("click", function () {
                $("#out-address-border").toggle();
                $("#in-address-border").toggle();
            });
            $("#save-address").on("click", function () {
               
                $("#out-address-border").toggle();
                $("#in-address-border").toggle();
               
            });
        });


