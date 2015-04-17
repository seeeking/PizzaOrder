<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<script type="text/javascript" src="<c:url value="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"/>" type="text/css"></script>
		<title>pizza order</title>
		<script>
			$(document).ready(function(){
				$(".num_order").change(function (){
					var tbl = document.getElementById('table');
					var rowLength = tbl.rows.length;
					var totalP = 0;
					var totalN = 0;
					$('#table tr').each(function(i) {
						if(i == 0 || i == rowLength-1) return;
					    var num = parseInt($(this).find("input").eq(0).val());
					    var pri = parseFloat($(this).find("td").eq(3).text());
						if(!isNaN(num)) {
					    	totalN += num;
					    	totalP = totalP + num*pri;
						}
					});
					$("#totalPrice").text(totalP);
					$("#totalNum").text(totalN);
				});
				function validForm() {
					var totalN = parseInt($("#totalNum"));
					if($("#buyer") == null || $("#buyer") == undefined 
						|| isNaN(totalN) || totalN == 0)  {
						return false;
					}
					return true;
				}
			});
		</script>
	</head>
	
	<body>
		<h1>Pizza Order</h1>
		<form id = "orderForm" action = "/make_order" onsubmit = "return validForm()" method = "post">
		<p>Please leave a name : <input type = "text" id = "buyer" required></input></p>
		<table id = "table">
		<tr>
			<th>name</th>
			<th>size</th>
			<th>catagory</th>
			<th>price</th>
			<th>number</th>
		</tr>
		<c:forEach items="${menu.catagory}" var = "cata">
			
			<c:forEach items="${cata.item}" var = "item">
			<tr>
				<td>${item.name}</td>
				<td>${item.size }</td>
				<td>${cata.name }</td>
				<td>${item.price }</td>
				<td><input type = "number" class="num_order" min = 0></input></td>
			</tr>
			</c:forEach>
			
		</c:forEach>
		<tr>
			<td>total</td>
			<td></td>
			<td></td>
			<td id = "totalPrice"></td>
			<td id = "totalNum"></td>
		</tr>
		</table>
		<input type = "submit">make order!</input>
		</form>
	</body>
</html>