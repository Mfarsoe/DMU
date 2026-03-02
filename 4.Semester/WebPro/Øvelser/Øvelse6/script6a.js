// Opgave 6a: ES5 Prototype
function Sprite(x, y, width, height, image) {
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
    this.image = image;
}

Sprite.prototype.draw = function(ctx) {
    ctx.drawImage(this.image, this.x, this.y, this.width, this.height);
};
