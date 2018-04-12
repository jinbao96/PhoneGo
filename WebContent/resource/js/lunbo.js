
        window.onload=function(){
            var img=document.getElementById("img");
            var i=1;
            var lb=function(){
                var imgs=["img/other/T1.jpg","img/other/T2.jpg","img/other/T3.jpg","img/other/T4.jpg","img/other/T5.jpg"];
                img.src=imgs[i];
                i++;
                if(i>=imgs.length){
                    i=0;
                }
            }
            var time=setInterval(lb,1000);
            img.onmouseover=function(){
                clearInterval(time);
            }
            img.onmouseout=function(){
                time=setInterval(lb,5000);
            }
        }
