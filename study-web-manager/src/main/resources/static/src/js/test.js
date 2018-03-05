/**
 * @author  chenjia
 * @create 2017-10-23 9:18
 * @desc
 **/
$(function () {
    $('.myfriends').onblur('click', function (event) {
        event.preventDefault();
        if($('.myfrd').is(":visible")){
            $('.myfrd').slideUp();
        }
    })
});