var count = 1;

$('#input').on('keyup',function(event){
  if(event.keyCode == 13){
    enterClicked();
  }
});

function enterClicked() {
	var input = document.getElementById('input');
	var value = parseFloat(input.value);

	if (isNaN(value))
		return false;
	
	stack = document.createElement("div");
	stack.innerHTML = '<val>' + value + '</val><span style="padding: 0px 5px 0px 5px; background:#333; border-radius:50%; color:white; float:right;">' + count + '</span>';
	stack.setAttribute("class","form-control text-left");
	stack.style.marginBottom = '3px';

	document.getElementById('stack').appendChild(stack);
	$("#input").val('');
	count++;
};

function add() {
	var value = document.getElementById('stack');
	var  len = document.querySelector('#stack').children.length;

	if (len == 0) {
		alert("Stos jest pusty");
		return false;
	}
	else if (len < 2) {
		alert("Za mało elementów na stosie. Min. 2 potrzebne.");
		return false;
	}

	stack = document.createElement("div");
	stack.setAttribute("class","form-control text-left");
	stack.style.marginBottom = '3px';

	var obj1 = value.removeChild(value.lastElementChild);
	var num1 = parseFloat(obj1.querySelector('val').innerHTML);
	var obj2 = value.removeChild(value.lastElementChild);
	var num2 = parseFloat(obj2.querySelector('val').innerHTML);

	out = num1 + num2;
	count -=2;

	stack.innerHTML = '<val>' + out + '</val><span style="padding: 0px 5px 0px 5px; background:#333; border-radius:50%; color:white; float:right;">' + count + '</span>';
	document.getElementById('stack').appendChild(stack);
	
	count++;
}

function sub() {
	var value = document.getElementById('stack');
	var  len = document.querySelector('#stack').children.length;

	if (len == 0) {
		alert("Stos jest pusty");
		return false;
	}
	else if (len < 2) {
		alert("Za mało elementów na stosie. Min. 2 potrzebne.");
		return false;
	}

	stack = document.createElement("div");
	stack.setAttribute("class","form-control text-left");
	stack.style.marginBottom = '3px';

	var obj1 = value.removeChild(value.lastElementChild);
	var num1 = parseFloat(obj1.querySelector('val').innerHTML);
	var obj2 = value.removeChild(value.lastElementChild);
	var num2 = parseFloat(obj2.querySelector('val').innerHTML);

	out = num1 - num2;
	count -=2;
	
	stack.innerHTML = '<val>' + out + '</val><span style="padding: 0px 5px 0px 5px; background:#333; border-radius:50%; color:white; float:right;">' + count + '</span>';
	document.getElementById('stack').appendChild(stack);
	
	count++;
}

function mul() {
	var value = document.getElementById('stack');
	var  len = document.querySelector('#stack').children.length;

	if (len == 0) {
		alert("Stos jest pusty");
		return false;
	}
	else if (len < 2) {
		alert("Za mało elementów na stosie. Min. 2 potrzebne.");
		return false;
	}

	stack = document.createElement("div");
	stack.setAttribute("class","form-control text-left");
	stack.style.marginBottom = '3px';

	var obj1 = value.removeChild(value.lastElementChild);
	var num1 = parseFloat(obj1.querySelector('val').innerHTML);
	var obj2 = value.removeChild(value.lastElementChild);
	var num2 = parseFloat(obj2.querySelector('val').innerHTML);

	out = num1 * num2;
	count -=2;
	
	stack.innerHTML = '<val>' + out + '</val><span style="padding: 0px 5px 0px 5px; background:#333; border-radius:50%; color:white; float:right;">' + count + '</span>';
	document.getElementById('stack').appendChild(stack);
	
	count++;
}

function div() {
	var value = document.getElementById('stack');
	var  len = document.querySelector('#stack').children.length;

	if (len == 0) {
		alert("Stos jest pusty");
		return false;
	}
	else if (len < 2) {
		alert("Za mało elementów na stosie. Min. 2 potrzebne.");
		return false;
	}

	var num2_temp = document.querySelector('#stack').children[0].querySelector('val').innerHTML;

	if (num2_temp == 0) {
		alert("Nie można dzilić przez zero");
		return false;
	}

	stack = document.createElement("div");
	stack.setAttribute("class","form-control text-left");
	stack.style.marginBottom = '3px';

	var obj1 = value.removeChild(value.lastElementChild);
	var num1 = parseFloat(obj1.querySelector('val').innerHTML);
	var obj2 = value.removeChild(value.lastElementChild);
	var num2 = parseFloat(obj2.querySelector('val').innerHTML);

	out = num1 / num2;
	count -=2;
	
	stack.innerHTML = '<val>' + out + '</val><span style="padding: 0px 5px 0px 5px; background:#333; border-radius:50%; color:white; float:right;">' + count + '</span>';
	document.getElementById('stack').appendChild(stack);
	
	count++;
}
