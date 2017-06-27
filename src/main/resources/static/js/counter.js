var minuta = 15;
var sekunda = 1;
var koniecczasu = 0;

function counter()
{

    if(minuta<=0&&sekunda<=0)
    {
        document.getElementById('clock').innerHTML='Koniec czasu - nastąpi przekierowanie do strony z wynikami';
        koniecczasu = 1;
        document.getElementById("formegzamin").submit();
    }

    sekunda=sekunda-1;
    if (sekunda<0) {sekunda=59; minuta=minuta-1;}
    if (minuta<0) {minuta=59;}

    if(minuta>=0&&sekunda>=0)
    {
        document.getElementById('clock').innerHTML='Do końca testu pozostało &rarr; '+minuta+' min '+sekunda+' sek' ;
        setTimeout("counter()",1000);
    }

}