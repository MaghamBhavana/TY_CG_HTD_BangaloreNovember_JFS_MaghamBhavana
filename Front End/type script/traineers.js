var Training = /** @class */ (function () {
    function Training() {
        this.name = 'abc';
        this.age = 34;
    }
    Training.prototype.printData = function () {
        console.log('hiii');
    };
    return Training;
}());
var tr = new Training();
tr.printData();
