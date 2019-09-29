
	
	
		//click tren menu
		// Lấy đối tượng có id = id-button trong jQuery
		// 	var object = $('#id-button');

		// sự kiên onload trong jquery 
		// 		$(document).ready(function(){ 
		//     /*Nội dung bên trong*/
		// });

		// khi gặp những đoạn code nằm trong sự kiện onload thì tình biên dịch sẽ bỏ qua cho tới khi trang web load xong		

		//var elements = $('.desc'): tìm tất cả các thẻ html có class ="desc"
		//nếu bạn thực hiện thao tác gán (set) thì nó có tác dụng cho toàn bộ kết quả
		//nếu bạn thực hiện thao tác lấy(get) thì nó có tác dụng cho kết quả đầu tiên.
		//vì vậy trong trường hợp get vì vậy trong trường hợp get ta phải sử dụng vòng lặp trong từng phần tử.

		// Truy vấn đối tượng : var element = $('.container');

		// Gán CSS background màu đỏ
		// $(element).css({
		//     background : "red"
		// });

		$(document).ready(
				function() {
					$('.navbar a.dropdown-toggle').on(
							//a.dropdown-toggle : thẻ a có class là dropdown-toggle ,.navbar : thẻ bao bộc bên ngoài là thẻ nav
							'click',
							function(e) {
								var $el = $(this);
								var $parent = $(this).offsetParent(
										".dropdown-menu");
								$(this).parent("li").toggleClass('open');
								if (!$parent.parent().hasClass('nav')) {
									$el.next().css({
										"top" : $el[0].offsetTop,
										"left" : $parent.outerWidth() - 4
									});
								}
								$('.nav li.open').not($(this).parents("li"))
										.removeClass("open");
								return false;
							});
				});		

//<!-- 	//export to excel from html table-->

	function exportTableToExcel(tableID,fileName='') {
		var downloadLink;
		var dataType = 'application/vnd.ms-excel';
		var tableSelect = document.getElementById(tableID);
	    var tableHTML = tableSelect.outerHTML.replace(/ /g, '%20'); //outerHTML: trả về mã html của phần tử hiện tại
	 
	    
	 // Specify file name
	    fileName = fileName? fileName +'.xls':'excel_data.xls';
	    	 
	 // Create download link element
	    downloadLink = document.createElement("a"); // tao the a
	    
	    document.body.appendChild(downloadLink);//chen them mot nut vao phia cuoi cung cua document
	    
	    
	    if(navigator.msSaveOrOpenBlob){ //method saves the File or Blob to disk.True is returned as long as the download notification bar is displayed, or false if a failure occurred
	        var blob = new Blob(['\ufeff', tableHTML], {
	            type: dataType
	        });
	        navigator.msSaveOrOpenBlob( blob, fileName);
	    }else{
	        // Create a link to the file
	        downloadLink.href = 'data:' + dataType + ', ' + tableHTML;
	    
	        // Setting the file name
	        downloadLink.download = fileName;
	        
	        //triggering the function
	        downloadLink.click();
	    }	    
	}

	
	
	
	//filter 
	function filter(){
	
		var input ,filter,listTable,textValue;
		input = document.getElementById("txtSearch");
		filter = input.value.toUpperCase();
		listTable = document.getElementById("tblListData");
		
		for(let row of listTable.rows){
			
			if(row.rowIndex > 0 ){//bỏ qua header
				
				for(let cell of row.cells){
					
					textValue = cell.textContent;
															
						if(textValue.toUpperCase().indexOf(filter) > -1){					
							row.style.display = "table-row";
							break;//neu da tim thay thi qua row khac
						} else{
							row.style.display = "none";
						}															
				}	
			} 
			
		}		
	};
		
		
	