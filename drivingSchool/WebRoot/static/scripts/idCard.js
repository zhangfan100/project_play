function ReadCard(target){
		var str = null;
		var result={};
		try{
			str = target.FindReader();
		}catch(e){
			str ="error4";
			result['status']=str;
			return result;
		}
		
		if (str > 0){
			if(str>1000){
				str ="error1";
			}else{
				str ="error2";
			}
		}
		else{
			str ="error3";
		}
		
		try{
			
			result['status']=str;
			/*target.SetReadType(3);
			target.SetBornType(3);*/
			
			target.SetReadType(0);
			target.SetPhotoName(3);
			target.SetBornType(3);
			
			var nRet = target.ReadCardMsg();
			if(nRet==0)
			{
				result['status']="success";
				result['name']=target.NameA;
				result['sex']=target.Sex;
				result['nation']=target.Nation;
				result['born']=target.Born;
				result['address']=target.Address;
				result['cardNo']=target.CardNo;
				result['userLifeB']=target.UserLifeB;
				result['userLifeE']=target.UserLifeE;
				result['police']=target.Police;
				result['photoName']=target.PhotoName;
			}
			return result;
		}catch(ex){}
	}