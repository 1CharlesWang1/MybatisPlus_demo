var usernameinput=document.getElementById("user_name");
usernameinput.onblur=checkUsername;
function checkUsername() {
    var username = usernameinput.value.trim();

    var flag=username.length>=1
    if(flag){
        document.getElementById("er1").style.display='none';
    }
    else{
        document.getElementById("er1").style.display='block';
    }
    return flag;
}



var passwordinput=document.getElementById("password");
passwordinput.onblur=checkPassword;
function checkPassword() {
    var password = passwordinput.value.trim();

    var flag=password.length>=1
    if(flag){
        document.getElementById("er2").style.display='none';
    }
    else{
        document.getElementById("er2").style.display='block';
    }
    return flag;
}

var checknuminput=document.getElementById("check_num");
checknuminput.onblur=checkchecknum;
function checkchecknum() {
    var checknum = checknuminput.value.trim();

    var flag=checknum==('cpuq' || 'CPUQ');
    if(flag){
        document.getElementById("er3").style.display='none';
    }
    else{
        document.getElementById("er3").style.display='block';
    }
    return flag;
}

// var regform=document.getElementById("regform");
// regform.onsubmit=function (){
//     var flag = checkUsername() && checkPassword() && checkchecknum();
//     if(flag)
//         alert("登陆成功");
//     return flag;
// }