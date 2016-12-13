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

                            sessionStorage.setItem('Username', parsedData[0]);
                            sessionStorage.setItem('Admin', parsedData[1]);
                            sessionStorage.setItem('Uid', parsedData[2]);

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
        sessionStorage.setItem('loggedIn', false);
        status = sessionStorage.getItem('loggedIn');
    }


}