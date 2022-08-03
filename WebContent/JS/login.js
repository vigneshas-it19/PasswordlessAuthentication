function login(){
    var email = document.getElementById("emailid").value;

    document.getElementById("container1").style = "cursor:wait";
    document.getElementById("submitbtn").style = "cursor:wait";
    
    $.getJSON('finduser', {email:email }, function(data, textStatus, jqXHR){
		var x = (JSON.parse(data.noOfRecordsJson)[0]).status;
        if(x=='no user found'){
            alert('No User Found using '+email+'\nPlease Register');
            return;
        }  
        else{
            $.getJSON('sendotp', {emailid:email }, function(data, textStatus, jqXHR){
                var x = (JSON.parse(data.otpSentJson)[0]).status;
                if(x=='successfully sent otp'){
                    document.getElementById("container1").style = "visibility:hidden";
                    document.getElementById("container2").style = "visibility:visible";
                }         
                })
                .done(function () { })
                .fail(function (jqxhr,settings,ex) { alert('failed, '+ ex); });
        }       
        })
        .done(function () { })
        .fail(function (jqxhr,settings,ex) { alert('failed, '+ ex); });
}


function validateOtp(){
    var enteredOtp = document.getElementById('otp1').value+""+document.getElementById('otp2').value+""+document.getElementById('otp3').value+""+document.getElementById('otp4').value+""+document.getElementById('otp5').value+""+document.getElementById('otp6').value;
    // alert(enteredOtp);
    var email = document.getElementById("emailid").value;

    $.getJSON('validateotp', {otp:enteredOtp }, function(data, textStatus, jqXHR){
		var x = (JSON.parse(data.otpValidateJson)[0]).status;
        if(x=='verified'){
            $.getJSON('login', {emailid:email }, function(data, textStatus, jqXHR){
                var x = (JSON.parse(data.loginSuccessJson)[0]).status;
                if(x=='loggedin'){
                    window.location.href = "dashboard";
                }         
                })
                .done(function () { })
                .fail(function (jqxhr,settings,ex) { alert('failed, '+ ex); });
        }
        else{
            alert("Incorrect OTP");
        }         
        })
        .done(function () {
            document.getElementById('otp1').value="";
            document.getElementById('otp2').value="";
            document.getElementById('otp3').value="";
            document.getElementById('otp4').value="";
            document.getElementById('otp5').value="";
            document.getElementById('otp6').value="";

         })
        .fail(function (jqxhr,settings,ex) { alert('failed, '+ ex); });
}
