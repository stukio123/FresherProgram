$("#refresh").on("click",function(){
			var sumInsured = $("#SumInsured").val();
			var rate = $("#Rate").val();
			var resultAnnual = (sumInsured*rate)/100;
			$("#AnnualPremium").val(resultAnnual);

		})