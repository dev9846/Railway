function loadDetails(imgID) {
    $.ajax({
        type: "POST",
        url: '_pizzaDetails',
        data: {
            itemID: imgID
        },
        success: function(data) {
            $('#pizzaDetailsTab').html(data);
        }

    });
}
function addToCart(btnCartId) {
    var addItem = btnCartId;
    var qty = document.getElementById("txtQty").value;
    var size = document.getElementsByName('size');

    for (var i = 0, length = size.length; i < length; i++) {
        if (size[i].checked) {
            var itemSize = size[i].value;
            break;
        }
    }

    $.ajax({
        type: "POST",
        url: '_addToCart',
        data: {
            itemID: addItem,
            itemQty: qty,
            itemSize: itemSize
        },
        success: function(data) {
            $('#cart').html(data);
        }
    });
}

$(document).ready(function() {
    
    $(".subMenu").click(function() {
        var btn = this.id;
        $.ajax({
            type: "POST",
            url: '_subMenuImages',
            data: {
                selectedBtn: btn
            },
            success: function(data) {
                $('#menuImgTab').html(data);
            }

        });
    });
    $(".item").click(function() {
        var item = this.id;
        $.ajax({
            type: "POST",
            url: '_pizzaDetails',
            data: {
                itemID: item
            },
            success: function(data) {
                $('#pizzaDetailsTab').html(data);
            }

        });
    });
});
