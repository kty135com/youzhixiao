var u1 = "10.6.20.18"
var u2 = "localhost"
var url = u1

function getXmlHttp() {
	var xmlHttp = false;
	if (window.XMLHttpRequest) {
		//  IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
		xmlHttp = new XMLHttpRequest();
	} else {
		//ie5,ie6
		try {
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		} catch (e) {
			xmlHttp = false;
		}
	}
	return xmlHttp;
}

function getUsers0(dept_id) {
	var select = document.getElementById("select0");
	if (dept_id == "") {
		select.length = 1;
	} else {
		select.length = 1;
		var xmlHttp = getXmlHttp();
		xmlHttp.onreadystatechange = function() {
			if (xmlHttp.readyState == 4) {
				if (xmlHttp.status = 200) {
					var users = xmlHttp.responseText //返回的user，
					var obj = eval(users);
					for (var i = 0; i < obj.length; i++) {
						option = document.createElement("option");
						option.innerHTML = obj[i].name;
						option.value = obj[i].id;
						select.appendChild(option);
					}
				}
			}
		}
		if (url == u2) {
			xmlHttp.open("post", "http://" + u2 + ":8080/project/watch/watch_getUsersJson", true);
		} else if (url == u1) {
			xmlHttp.open("post", "http://" + u1 + ":8080/project/watch/watch_getUsersJson", true);
		} else {
			alert("Ajax传输错误，请重试，如多次失误请联系管理员")
		}
		xmlHttp.setRequestHeader("Content-type", "text/plain");
		xmlHttp.send("dept.id=" + dept_id);
	}
}

function getUsers1(dept_id) {
	var select = document.getElementById("select1");
	if (dept_id == "") {
		select.length = 1;
	} else {
		select.length = 1;
		var xmlHttp = getXmlHttp();
		xmlHttp.onreadystatechange = function() {
			if (xmlHttp.readyState == 4) {
				if (xmlHttp.status = 200) {
					var users = xmlHttp.responseText //返回的user，
					var obj = eval(users);
					for (var i = 0; i < obj.length; i++) {
						option = document.createElement("option");
						option.innerHTML = obj[i].name;
						option.value = obj[i].id;
						select.appendChild(option);
					}
				}
			}
		}
		if (url == u2) {
			xmlHttp.open("post", "http://" + u2 + ":8080/project/watch/watch_getUsersJson", true);
		} else if (url == u1) {
			xmlHttp.open("post", "http://" + u1 + ":8080/project/watch/watch_getUsersJson", true);
		} else {
			alert("Ajax传输错误，请重试，如多次失误请联系管理员")
		}
		xmlHttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		xmlHttp.send("dept.id=" + dept_id);
	}
}

function getUsers2(dept_id) {
	var select = document.getElementById("select2");
	if (dept_id == "") {
		select.length = 1;
	} else {
		select.length = 1;
		var xmlHttp = getXmlHttp();
		xmlHttp.onreadystatechange = function() {
			if (xmlHttp.readyState == 4) {
				if (xmlHttp.status = 200) {
					var users = xmlHttp.responseText //返回的user，
					var obj = eval(users);
					for (var i = 0; i < obj.length; i++) {
						option = document.createElement("option");
						option.innerHTML = obj[i].name;
						option.value = obj[i].id;
						select.appendChild(option);
					}
				}
			}
		}
	}
	if (url == u2) {
		xmlHttp.open("post", "http://" + u2 + ":8080/project/watch/watch_getUsersJson", true);
	} else if (url == u1) {
		xmlHttp.open("post", "http://" + u1 + ":8080/project/watch/watch_getUsersJson", true);
	} else {
		alert("Ajax传输错误，请重试，如多次失误请联系管理员")
	}
	xmlHttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xmlHttp.send("dept.id=" + dept_id);
}

function getPro2(pro1_id) {
	var select = document.getElementById("pro2select");
	if (pro1_id == "") {
		select.length = 1;
	} else {
		select.length = 1;
		var xmlHttp = getXmlHttp();
		xmlHttp.onreadystatechange = function() {
			if (xmlHttp.readyState == 4) {
				if (xmlHttp.status = 200) {
					var pro2s = xmlHttp.responseText //返回的user，
					var obj = eval(pro2s);
					for (var i = 0; i < obj.length; i++) {
						option = document.createElement("option");
						option.innerHTML = obj[i].name;
						option.value = obj[i].id;
						select.appendChild(option);
					}
				}
			}
		}
		if (url == u2) {
			xmlHttp.open("post", "http://" + u2 + ":8080/project/project3/project3_getPro2sJson", true);
		} else if (url == u1) {
			xmlHttp.open("post", "http://" + u1 + ":8080/project/project3/project3_getPro2sJson", true);
		} else {
			alert("Ajax传输错误，请重试，如多次失误请联系管理员")
		}
		xmlHttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		xmlHttp.send("id=" + pro1_id);
	}
}

function getPro3(pro2_id) {
	var select = document.getElementById("pro3select");
	if (pro2_id == "") {
		select.length = 1;
	} else {
		select.length = 1;
		var xmlHttp = getXmlHttp();
		xmlHttp.onreadystatechange = function() {
			if (xmlHttp.readyState == 4) {
				if (xmlHttp.status = 200) {
					var pro2s = xmlHttp.responseText //返回的user，
					var obj = eval(pro2s);
					for (var i = 0; i < obj.length; i++) {
						option = document.createElement("option");
						option.innerHTML = obj[i].name;
						option.value = obj[i].id;
						select.appendChild(option);
					}
				}
			}
		}
		if (url == u2) {
			xmlHttp.open("post", "http://" + u2 + ":8080/project/task/task_getPro3sJson", true);
		} else if (url == u1) {
			xmlHttp.open("post", "http://" + u1 + ":8080/project/task/task_getPro3sJson", true);
		} else {
			alert("Ajax传输错误，请重试，如多次失误请联系管理员");
		}
		xmlHttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		xmlHttp.send("id=" + pro2_id);
	}
}

function getTask(pro3_id) {
	var select = document.getElementById("taskselect");
	if (pro3_id == "") {
		select.length = 1;
	} else {
		select.length = 1;
		var xmlHttp = getXmlHttp();
		xmlHttp.onreadystatechange = function() {
			if (xmlHttp.readyState == 4) {
				if (xmlHttp.status = 200) {
					var pro2s = xmlHttp.responseText //返回的user，
					var obj = eval(pro2s);
					for (var i = 0; i < obj.length; i++) {
						option = document.createElement("option");
						option.innerHTML = obj[i].mo;
						option.value = obj[i].id;
						select.appendChild(option);
					}
				}
			}
		}
		if (url == u2) {
			xmlHttp.open("post", "http://" + u2 + ":8080/project/watch/watch_getTasksJson", true);
		} else if (url == u1) {
			xmlHttp.open("post", "http://" + u1 + ":8080/project/watch/watch_getTasksJson", true);
		} else {
			alert("Ajax传输错误，请重试，如多次失误请联系管理员")
		}
		xmlHttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		xmlHttp.send("id=" + pro3_id);
	}
}