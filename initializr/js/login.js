var printed = false;
function login() {
    $("#login").submit(function (e) {
        var postData = $(this).serialize();
        var formURL = $(this).attr("action");
        var logged = false;

        $.ajax(
                {
                    url: formURL,
                    type: "POST",
                    data: postData,
                    success: function (data)
                    {

                        parsedData = null;
                        parsedData = JSON.parse(data);


                        if (parsedData[0] === false) {

                            $('#username').val('');
                            $('#password').val('');
                            if (!printed) {
                                $("#after").append("<p>Wrong username or password</p>");
                                printed = true;
                            }
                        } else {

                            sessionStorage.setItem('user', parsedData[0]);
                            sessionStorage.setItem('role', parsedData[1]);
                            sessionStorage.setItem('userId', parsedData[2]);

                            logged = true;
                            window.location.replace('index.html');
                        }

                        sessionStorage.setItem('loggedIn', logged);

                    }
                });
        e.preventDefault(); //STOP default action
    });
    $("#login").submit();
}
;



function logout() {
    sessionStorage.setItem('loggedIn', false);
    //$("#logout").load();
    //$("#login1").load();
    //$( "#user" ).load();
}
function onLoad() {

    var status = sessionStorage.getItem('loggedIn');
    if (!status) {
        sessionStorage.setItem('loggedIn', 'no');
        status = sessionStorage.getItem('loggedIn');
    }

    if (status === false) {//out
        $("#logout").hide();
        $("#user").empty();

    }
    else {//in
        $("#login1").hide();
        $("#user").empty();
        $("#user").append(sessionStorage.getItem('user'));

    }

}