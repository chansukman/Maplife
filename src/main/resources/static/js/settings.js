let tabProfileButton =document.getElementById("profileButton")
let tabPrivacyButton =document.getElementById("privacyButton")
let profileIcon=document.getElementById("profileIcon")
let inputChoose=document.getElementById("inputChoose")
let uploadIconButton=document.getElementById("uploadIconButton")

document.onreadystatechange=function (){
    if (document.readyState=="complete"){
        getUserIcon()
    }
}
const getUserIcon =  function (){
    profileIcon.setAttribute("src","image/"+userJsonIcon)
}
getUserIcon()


const profileTab = function (){
    tabPrivacyButton.className="nav-item";
    tabProfileButton.className="current";
    document.getElementById("settings-profile").style.display="block";
    document.getElementById("settings-privacy").style.display="none";
}
const privacyTab = function (){
    tabProfileButton.className="nav-item";
    tabPrivacyButton.className="current";
    document.getElementById("settings-profile").style.display="none";
    document.getElementById("settings-privacy").style.display="block";
}

 function changeUserIcon() {
    let fileData = inputChoose.files[0]
    var reader = new FileReader();
    reader.readAsDataURL(fileData);//异步读取文件内容，结果用data:url的字符串形式表示
    /*当读取操作成功完成时调用*/
    reader.onload = function (e) {
        // console.log(e);
        // console.log(this.result);
        // console.log(fileData.name)
        profileIcon.setAttribute("src", this.result)

    }
}

async function getNewIcon() {
    let fileData = inputChoose.files[0]
    const formObject = new FormData();
    formObject.append("image", fileData);

    const response = await fetch("api/uploadImage", {
        method: "POST",
        headers: {
            Accept: "application/json",
        },
        body: formObject
    });
    if (response.status == "200") {
        profileIcon.setAttribute("src", fileData.name)
    }

    // const response2 =await  fetch("api/updateImage", {
    //     method: "PUT",
    //     }
    // )

}

uploadIconButton.addEventListener("click",getNewIcon)
inputChoose.addEventListener("change",changeUserIcon)
tabProfileButton.addEventListener("click",profileTab)
tabPrivacyButton.addEventListener("click",privacyTab)
