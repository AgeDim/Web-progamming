function draw_shot(data) {
    const circle = document.createElementNS('http://www.w3.org/2000/svg', 'circle');
    circle.setAttribute('r', '3');
    let rvalue = Number(data.rval);
    let xvalue = Number(data.xval);
    let yvalue = Number(data.yval);
    circle.setAttribute('r', '3');
    circle.setAttribute('cx', 200 + 150 / rvalue * xvalue);
    circle.setAttribute('cy', 200 - 150 / rvalue * yvalue);
    if (data.result === "true") {
        circle.setAttribute('fill', 'LIME');
    } else {
        circle.setAttribute('fill', 'RED');
    }
    document.getElementById('svg').appendChild(circle);
}

function time() {
    $("#div2").load(location.href + ' #div2')
}
setInterval(time, 11000)

function checkHit(event) {
    let r_val = document.forms[1].elements[5].value;
    let cordX = event.pageX - $('#svg').offset().left;
    let cordY = event.pageY - $('#svg').offset().top;
    let x_val = (cordX - 200) / 150 * 4;
    let y_val = (200 - cordY) / 150 * 4;
    document.forms[2].elements[4].value = x_val;
    document.forms[2].elements[5].value = y_val;
    document.forms[2].elements[0].click();
}

function add_row(data) {
    let xv = data.xval;
    let yv = data.yval;
    let exec = data.executeTime;
    let row = $('<tr>');
    $('<td>').html(parseFloat(xv).toFixed(3)).appendTo(row);
    $('<td>').html(parseFloat(yv).toFixed(3)).appendTo(row);
    $('<td>').html(data.rval).appendTo(row);
    $('<td>').html(data.currentTime).appendTo(row);
    $('<td>').html(parseFloat(exec).toFixed(7)).appendTo(row);
    $('<td>').html(data.result).appendTo(row);
    $(row).insertAfter($('#result-table tr:last').eq(0));
}

// function updateRadius() {
//     let r = $('#r-textinput');
//     if (r > 4 || r < 1){return;}
//     let path = "M 200 " + (200-150*r/4) + " L 200 " + (200-75*r/4) + " L " + (200+150*r/4) + " " + (200-75*r/4) +
//         " L " + (200-150*r/4) + " 200 L 200 200 L 200 " + (200-150*r/4) + " A " + (150*r/4) + " " + (150*r/4) +
//         " 0 0 1 " + (200-150*r/4) + " 200 L 200 " + (200-150*r/4);
//     $("#path").attr("d", path);
// }

