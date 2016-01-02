function ResizeImages()
{
   var myimg,oldwidth,oldheight;
   var maxwidth=550;
   var maxheight=880;
   var imgs = document.getElementById('404').getElementsByTagName('img');   //如果你定义的id不是article，请修改此处

   for(i=0;i<imgs.length;i++){
     myimg = imgs[i];

     if(myimg.width > myimg.height)
     {
         if(myimg.width > maxwidth)
         {
            oldwidth = myimg.width;
            myimg.height = myimg.height * (maxwidth/oldwidth);
            myimg.width = maxwidth;
         }
     }else{
         if(myimg.height > maxheight)
         {
            oldheight = myimg.height;
            myimg.width = myimg.width * (maxheight/oldheight);
            myimg.height = maxheight;
         }
     }
   }
}