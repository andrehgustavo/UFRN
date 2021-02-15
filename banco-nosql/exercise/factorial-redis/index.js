const express = require('express')
const redis = require('redis')
const cache = redis.createClient()
const app = express()
const port = 3000

cache.on('connect', () => {
  console.log('Redis is ready');
});
 
cache.on('error', (e) => {
  console.log('Redis error', e);
});

app.get('/fatorial/:key', (req, res) => {
    const key = "fat-" + req.params.key;
    cache.get(key, (err, reply) => {
        if (err){
            res.send('ERROR')
        }else{
            if(reply === null){
                save(key, res);
            }else{
                res.send(`Cache: F[${key.substring(4)}] = ` + reply);
            }
        }
    })
})
function save(key, res){
    const fatValue = factorial(key.substring(4));
    cache.set(key, fatValue, 'EX',60*5, function (err, reply){
        if (err){
            res.send('ERROR')
        }else{
            //res.send(factorial(req.params.key));
            res.send(`New fatorial: F[${key.substring(4)}] = ` + fatValue);
        }
    })
}

function factorial(num){
    return num <= 1 ? 1 : num * factorial(num-1);
}

app.listen(port, () => console.log(`Example app listening on port ${port}!`))