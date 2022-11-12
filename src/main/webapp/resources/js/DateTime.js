var date = new Date;
var options = {
	year : 'numeric',
	month : 'long',
	day : 'numeric',
};
document.getElementById('dateOnMinePage').textContent = date.toLocaleString(
		"ru", options);


var timeNode = document.getElementById('time-header');

function getCurrentTimeString() {
   return new Date().toTimeString().replace(/ .*/, '');
}

setInterval(
   () => timeNode.innerHTML = getCurrentTimeString(),
   1000
);