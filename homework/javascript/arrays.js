   /********************************************************************************
     *
     *    Desafio: Identificar o número mais repetido e apresente os seus índices
     *
     ********************************************************************************/
    
const numbers = [12, 3, 4, 5, 6, 7, 12, 12, 7, 8];
const count = {}; // variavel para guardar a contagem

numbers.array.forEach(num => {
    count[num] = (count[num] || 0) + 1; // acrescenta +1 quando ve o numero mais q uma vez
});

let morerepeated = null; //esta variavel atualiza o valor quando souber qual o numero mais repetido
let maxcount = 0;

for (let num in count) {
    if (count[num] > maxCount) {
        maxCount = count
    }
}
