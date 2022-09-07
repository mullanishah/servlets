
	function getSelectedStudent() 
	{
		var selectedStudent = document.querySelector('input[name = "students"]:checked');

		if(selectedStudent != null){
			alert(selectedStudent.value);
		}	
	}