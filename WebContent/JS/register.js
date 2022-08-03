function sendOtp(){
    var email = document.getElementById("emailid").value;

    document.getElementById("container1").style = "cursor:wait";
    document.getElementById("submitbtn").style = "cursor:wait";
    
    $.getJSON('finduser', {email:email }, function(data, textStatus, jqXHR){
		var x = (JSON.parse(data.noOfRecordsJson)[0]).status;
        if(x=='user found'){
            alert('Already registered using '+email+'\nPlease Login');
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
    $.getJSON('validateotp', {otp:enteredOtp }, function(data, textStatus, jqXHR){
		var x = (JSON.parse(data.otpValidateJson)[0]).status;
        if(x=='verified'){
            document.getElementById("container1").style = "visibility:hidden";
            document.getElementById("container2").style = "visibility:hidden";
            document.getElementById("container3").style = "visibility:visible";
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


function register(){
    var name = document.getElementById("name").value;
    var email = document.getElementById("emailid").value;
    var phone = document.getElementById("phone").value;
    var place = document.getElementById("place").value;
    data={
        name : name,
        email:email,
        location:place,
        phone:phone
    }
    $.getJSON('register', data, function(data, textStatus, jqXHR){
		var x = (JSON.parse(data.registrationSuccessJson)[0]).status;
        if(x=='successfully registered'){
            window.location.href = "login.jsp";
        }
        else{
            alert("Some problem occured");
        }         
        })
        .done(function () {
            
         })
        .fail(function (jqxhr,settings,ex) { alert('failed, '+ ex); });
}