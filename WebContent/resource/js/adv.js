jQuery(function(){
		var fwidth=$("#focus").width();//�����������Ŀ��
		var adv_count=$("#focus ul li").length;//�õ���������
		var index=0;//��ǰ��ʾ�Ĺ��
		var picTimer;//���ÿ���ͼƬ�л��Ķ�ʱ��
		//ÿ����涼��Ӧ��һ��span
		var btn="<div class='icon'>";
		for(var i=0;i<adv_count;i++){
			btn+="<span></span>";

		}
		//�����ƶ��İ�ť
		btn+="</div><div class='prenext pre'></div><div class='prenext next'></div>";
		//���btnԪ�ص�focus
		$("#focus").append(btn);

		//����Ϊ���ҹ�����������liԪ�ض�����ͬһ�����󸡶�������������Ҫ�������ΧulԪ�صĿ��
		$("#focus ul").css("width",fwidth * (adv_count));
		$("#focus .icon span").css("opacity",0.6).mouseover(function(){
			index=$("#focus .icon span").index(this);//��ȡ�ƶ���span����span������±�
			showPics(index);
		}).eq(0).trigger("mouseover");//�ó���ģ�����
		
		//��ʾͼƬ���������ݽ��յ�indexֵ��ʾ��Ӧ������
		function showPics(index){
			var nowLeft = -index*fwidth; //����indexֵ����ulԪ�ص�leftֵ
			$("#focus ul").stop(true,false).animate({"left":nowLeft},300); //ͨ��animate()����ulԪ�ع������������position,true:�������δִ����Ķ������У�false�����Ƿ�ֱ�ӽ�����ִ�еĶ�����ת��ĩ״̬��
			$("#focus .icon span").removeClass("on").eq(index).addClass("on"); //Ϊ��ǰ�İ�ť�л���ѡ�е�Ч��
			$("#focus .icon span").stop(true,false).animate({"opacity":"0.6"},300).eq(index).stop(true,false).animate({"opacity":"1"},300); //Ϊ��ǰ�İ�ť�л���ѡ�е�Ч������Ϊ��͸��
		}

		//��һҳ����һҳ��ť͸���ȴ���
		$("#focus .prenext").css("opacity","0").hover(function() {
			$(this).stop(true,false).animate({"opacity":"0.6"},300);
		},function() {
			$(this).stop(true,false).animate({"opacity":"0"},300);
		});
		
		//��һҳ��ť
		$("#focus .pre").click(function() {
			index -= 1;
			if(index == -1) {index = adv_count - 1;}
			showPics(index);
		});

		//��һҳ��ť
		$("#focus .next").click(function() {
			index += 1;
			if(index == adv_count) {index = 0;}
			showPics(index);
		});

		//��껬�Ͻ���ͼʱֹͣ�Զ����ţ�����ʱ��ʼ�Զ�����
		$("#focus").hover(function() {
			clearInterval(picTimer);
		},function() {
			picTimer = setInterval(function() {
				showPics(index);
				index++;
				if(index == adv_count) {index = 0;}
			},3000); //��3000�����Զ����ŵļ������λ������
		}).trigger("mouseleave");


	});