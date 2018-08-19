/**
 * 
 */
function buildUserTable(data) {
	var html = '';
	for (var mydata=0;mydata < data.length; mydata++) {
		html += '<b>User-Id : </b>'+ data[mydata]['id']
		html += '<b>Name : </b>'+ data[mydata]['username']+'<br>'
	}
	
	alert(html);
	$("#user-data").html(html);
}
$(document).ready(function(){

	var request = $.ajax({
		url : "/all",
		type : "GET" 
	});

	request.done(function(data) {
		if(data.length > 0) {
			buildUserTable(data);
		} else {
			alert("NO data");
		}
	});
	
});
