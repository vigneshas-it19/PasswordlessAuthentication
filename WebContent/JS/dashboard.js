
function getUser(x){
    // var email = document.getElementById("emailid").value;
    var email = x
    var name;
    $.getJSON('getuser', {emailid:email }, function(data, textStatus, jqXHR){
		var x = (JSON.parse(data.userDetailsJson)[0]);
        name = x.name;
        })
        .done(function () {
            document.getElementById('name').innerHTML = name;
            document.getElementById('title').innerHTML = name;
         })
        .fail(function (jqxhr,settings,ex) { alert('failed, '+ ex); });
}



window.onload = function(){
    console.log(document.getElementById('title').innerHTML.toString().trim());
    getUser(document.getElementById('title').innerHTML.toString().trim());
}