// This program generates 500 random numbers and outputs the nth smallest number.

function NthSmallest() {
    var num = [];
    var nthSmallest = Infinity;


    // Generate 500 random numbers between 0 and 500 (round down decimal).
    for (let i = 0; i < 500; i++){
        num[i] = Math.floor(Math.random() * 500);

        // Number at i-th index becomes smallest if smaller than nthSmallest.
        if (num[i] < nthSmallest) {
            nthSmallest = num[i];
        }
    }

    console.log(num);
    console.log("\nIndex of first occurence of smallest number: " + num.indexOf(nthSmallest));
    console.log("Smallest number in array: " + nthSmallest);
}

NthSmallest();