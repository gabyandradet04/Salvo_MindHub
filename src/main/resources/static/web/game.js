function actualPlayer(id){
$.get( "http://localhost:8080/api/game_view/"+id)
.done(function(data) {
console.log(data);
salvoes= data.salvos;
ship = data.ships;
gPLayers= data.gamePlayers;
Celdas(ship, salvoes, id);
title(gPLayers, id);
})
.fail(function() {
alert( "error" );
});
}
// Verifica en que pagina está para comparar con el jugador
var url = window.location.href;
console.log(url);
function checkPlayer (string) {
var newString = string.slice(string.indexOf("=") + 1);
return  newString;
}
actualPlayer(checkPlayer(url));

/*************************************/
//Funcion para Matcar los Barcos
function Celdas(app,salvoes,id){
  var g=[];
  var j=[];
  var idJug;

//obtiene array de location
    g= app.map(function(obj){
      return obj.location
    });
//obtiene array donde se tiene las celdas donde se encuentran los barcos
  for (var i = 0; i<g.length; i++) {
    g[i].map(function(ob){
     return j.push(ob)
    });
  };
//Obtiene la celda y marca en HTML el lugar de los barcos
  for(a=0; a<j.length; a++){
    var cla=document.getElementsByClassName(j[a])
  $(cla).addClass("barco");
  };
  /**************************************/
  var q=[];
  var tabSalvo=[];
  var tabShip=[];
  var turno=[];

  gPLayers.map( function(arr){
    if(arr.id == id){
      console.log(arr)
      console.log(arr.player.id)
      return idJug= arr.player.id
    }
    return idJug
  });
  //Obtiene array con las localizaciones de los salvos del jugador y otro array con las localizaciones de los salvos del otro jugador
  salvoes.map( function(arr){
    if(arr.player == idJug){
      return arr.salvoLocation.map(function(sal){
        turno.push(arr.turn);// array con los turnos de los disparos del jugador
        return tabSalvo.push(sal);//array con localizaciones de disparos del jugador 
       });
    }else{
     return arr.salvoLocation.map(function(sal){
        return tabShip.push(sal);//array con las localizaciones que el jugador dispara nuestros barcos
      });
    };
  });

/*********************************/
// Muestra en HTML los disparos del jugador y el turno en tabla SALVO
  tabSalvo.map(function(l,ind){
    var ids =document.getElementById(l)
     $(ids).addClass("disp");
    document.getElementById(l).innerHTML=turno[ind];
  });

//Muestra en HTML los disparos
console.log("ll" + tabShip)
console.log("l" +j)
var arrDisp = j;
  tabShip.map(function(ll){
    j.map(function(l){
      if(ll==l){
        var sh = document.getElementsByClassName(ll)
        $(sh).addClass("explo");

      }else {
        var idx = j.indexOf(ll)
        if (idx==-1){
          console.log(ll)
          var fall = document.getElementsByClassName(ll);
          $(fall).addClass("fallo");
        };
      };
    });
  });
};
/*****************************/
function title (gPLayers, ids){
  gPLayers.map(function(pa){
    if(pa.id==ids){
     return  gp = pa.player.email;
    }else if(pa.id != ids){
      return otherp= pa.player.email;
    };
  });
  y ="<p> Player 1: "+ gp +" (you) VS Player 2:" + otherp +"</p>";
  y1= "<p> Player 2: " + otherp+ "</p>";
  document.getElementById("localPlayer").innerHTML=y;
  document.getElementById("titleSalvo").innerHTML = y1;
};