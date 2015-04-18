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
					var totalN = parseInt($("#totalNum").text());
					if($("#customer").val() == null || $("#customer").val() == undefined 
						|| isNaN(totalN) || totalN == 0)  {
						return false;
					}
					return true;
				}
				function getJSONOrder() {
					var cart = {};
					cart["customer"] = $("#customer").val();
					cart["total_num"] = $("#totalNum").text();
					cart["total_price"] = $("#totalPrice").text();
					// cart["date"] = new Date();
					var tbl = document.getElementById('table');
					var rowLength = tbl.rows.length;
					var orders = [];
					var header = [];
					var rowHead = tbl.rows[0];
					for(var i = 0; i < rowHead.cells.length; ++i) {
						header.push(rowHead.cells[i].innerHTML);
					}
					$('#table tr').each(function(i) {
						if(i == 0 || i == rowLength-1) return;
					    var num = parseInt($(this).find("input").eq(0).val());
					    if(isNaN(num) || num === 0) {
					    	return;
					    }
						var item = {}
						var order = {}
						$(this).find("td").each(function(i) {
							if(i == rowHead.cells.length-1) return;
							var ss = $(this).text();
							if(ss.length === 0) ss = "empty";
							item[header[i]] = ss;
						});
					    order["item"] = item;
					    order["number"] = num;
					    order["customer"] = $("#customer").val();
					    orders.push(order);
					});
					cart["orders"] = orders;
					return JSON.stringify(cart);
				}
				$('#orderForm').submit(function (event) {
					var x = validForm();
					if(!x) {
						alert("invalid order");
					}
					var cart = getJSONOrder();
					$.ajax({
						url : "make_order",
						type : "POST",
						data : cart,
						dataType: 'text',
						contentType: 'application/json',
					    mimeType: 'application/json',
					    timeout: 1000,
						success: function(msg) {
							alert(msg);
						}, 
						error: function(xhr, textStatus, errorThrown){
							alert(xhr + textStatus + errorThrown);
						}
					});
				});
			});
		</script>
	</head>
	
	<body>
		<h1>Pizza Order</h1>
		<form id = "orderForm">
		<p>Please leave a name : <input type = "text" id = "customer" required></input></p>
		<table id = "table">
		<tr>
			<th>name</th>
			<th>size</th>
			<th>category</th>
			<th>price</th>
			<th>number</th>
		</tr>
		<c:forEach items="${menu.item}" var = "item">
			<tr>
				<td>${item.name}</td>
				<td>${item.size }</td>
				<td>${item.catagory }</td>
				<td>${item.price }</td>
				<td><input type = "number" class="num_order" min = 0></input></td>
			</tr>			
		</c:forEach>
		<tr>
			<td>total</td>
			<td></td>
			<td></td>
			<td id = "totalPrice"></td>
			<td id = "totalNum"></td>
		</tr>
		</table>
		<input type = "submit" id = "make_order", value = "make order!"></input>
		</form>s
	</body>
</html>