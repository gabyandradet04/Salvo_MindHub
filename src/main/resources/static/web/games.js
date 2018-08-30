$.get("/api/games").done(function(data){
    app.games = data;
    console.log(app.games);
    dateFormat();
    createStatsObject();
});

function dateFormat (){
    for (var i in app.games){
        var newDate = new Date(app.games[i].created).toLocaleString();
        app.games[i].created = newDate;
    }
}

//Creación del objeto JSON dinámico
var stats = {
   "eachPlayer": []
}

function createStatsObject() {
    for (var i in app.games) {
        for (var j in app.games[i].gamePlayer) {
            var examine = stats.eachPlayer.find(function(player){ return player.id == app.games[i].gamePlayer[j].player.id });
            if (examine == undefined) {
                 var statsObject = new Object();
                 statsObject.userName = app.games[i].gamePlayer[j].player.email;
                 statsObject.id = app.games[i].gamePlayer[j].player.id;
                 statsObject.score = 0;
                 statsObject.win = 0;
                 statsObject.lose = 0;
                 statsObject.tie = 0;
                 stats.eachPlayer.push(statsObject);
            }
            calcScore(app.games[i].gamePlayer[j].score.score, app.games[i].gamePlayer[j].player.id);
        }
    }
}

//Función que realiza el cálculo de la tabla de puntos
function calcScore (score, playerId) {
   stats.eachPlayer.map(function(eachPlayer) {
       if (playerId == eachPlayer.id) {
           eachPlayer.score += score;
           if (score == 1.0) {
              eachPlayer.win ++
           }
           else if (score == 0.0) {
              eachPlayer.lose ++
           }
           else if (score == 0.5) {
              eachPlayer.tie ++
           }
        }
    })
}


var app = new Vue({
  el: '#app',
    data: {
       games: [],
       stats: stats
    }
});