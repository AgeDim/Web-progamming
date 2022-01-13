<template>
  <div id="content">
    <script type="application/javascript">
      $.fn.form.settings.rules.doubleRange = function (value, range) {
        let numberRegExp = $.fn.form.settings.regExp.number;
        let parts = range.split('..', 2);
        let min = parts[0] - 0;
        let max = parts[1] - 0;
        return value !== '' && numberRegExp.test(value) && value >= min && value <= max;
      };
      $(document).ready(function () {
        $('.ui.form').form({
          fields: {
            y: {
              identifier: 'y',
              rules: [
                {
                  type: 'empty',
                  prompt: 'You can\'t leave coordinate y unset'
                },
                {
                  type: 'doubleRange[-5..5]',
                  prompt: 'Coordinate y must be a number between -5 and 5'
                }
              ]
            }
          },
          onSuccess(e) {
            e.preventDefault();
          }
        });
      });
    </script>
    <div class="ui inverted vertical segment"
         style="padding: 8.5px; position: sticky; top: 0; margin-top: 0; z-index: 101; width: 100%;">
      <div class="ui large inverted secondary menu adaptive">
        <a class="active item">
          <i class="home icon"></i>Main
        </a>
        <div class="right menu">
          <a class="item" @click="logout">
            Logout&nbsp;<i class="sign-out icon"></i>
          </a>
        </div>
      </div>
    </div>
    <form class="ui form adaptive">
      <div class="ui raised blue segment adaptive">
        <h2 class="ui header" style="text-align: center;">Graph</h2>
        <canvas id="canvas" title="Click to add a point"/>
      </div>
      <div class="ui raised green segment adaptive">
        <h2 class="ui header" style="text-align: center;">Add point</h2>
        <h4 style="margin-top: 0;">Coordinate X</h4>
        <div class="field" style="display: inline-block; margin-right: 1em;margin-bottom: 16px;">
          <div class="ui radio checkbox">
            <input type="radio" name="x" tabindex="0" value="-4">
            <label>-4</label>
          </div>
        </div>
        <div class="field" style="display: inline-block; margin-right: 1em;">
          <div class="ui radio checkbox">
            <input type="radio" name="x" tabindex="0" checked value="-3">
            <label>-3</label>
          </div>
        </div>
        <div class="field" style="display: inline-block; margin-right: 1em;">
          <div class="ui radio checkbox">
            <input type="radio" name="x" tabindex="0" value="-2">
            <label>-2</label>
          </div>
        </div>
        <div class="field" style="display: inline-block; margin-right: 1em;">
          <div class="ui radio checkbox">
            <input type="radio" name="x" tabindex="0" value="-1">
            <label>-1</label>
          </div>
        </div>
        <div class="field" style="display: inline-block; margin-right: 1em;">
          <div class="ui radio checkbox">
            <input type="radio" name="x" tabindex="0" value="0">
            <label>0</label>
          </div>
        </div>
        <div class="field" style="display: inline-block; margin-right: 1em;">
          <div class="ui radio checkbox">
            <input type="radio" name="x" tabindex="0" value="1">
            <label>1</label>
          </div>
        </div>
        <div class="field" style="display: inline-block; margin-right: 1em;">
          <div class="ui radio checkbox">
            <input type="radio" name="x" tabindex="0" value="2">
            <label>2</label>
          </div>
        </div>
        <div class="field" style="display: inline-block; margin-right: 1em;">
          <div class="ui radio checkbox">
            <input type="radio" name="x" tabindex="0" value="3">
            <label>3</label>
          </div>
        </div>
        <div class="field" style="display: inline-block;">
          <div class="ui radio checkbox">
            <input type="radio" name="x" tabindex="0" value="4">
            <label>4</label>
          </div>
        </div>
        <h4 style="margin-top: 0;">Coordinate Y</h4>
        <div class="field">
          <input type="text" name="y" placeholder="Number from -5 to 5...">
        </div>
        <h4 style="margin-top: 0;">Radius</h4>
        <div class="field" style="display: inline-block; margin-right: 1em; margin-bottom: 16px;">
          <div class="ui radio checkbox">
            <input type="radio" name="r" tabindex="0" value="-4">
            <label>-4</label>
          </div>
        </div>
        <div class="field" style="display: inline-block; margin-right: 1em;">
          <div class="ui radio checkbox">
            <input type="radio" name="r" tabindex="0" value="-3">
            <label>-3</label>
          </div>
        </div>
        <div class="field" style="display: inline-block; margin-right: 1em;">
          <div class="ui radio checkbox">
            <input type="radio" name="r" tabindex="0" value="-2">
            <label>-2</label>
          </div>
        </div>
        <div class="field" style="display: inline-block; margin-right: 1em;">
          <div class="ui radio checkbox">
            <input type="radio" name="r" tabindex="0" value="-1">
            <label>-1</label>
          </div>
        </div>
        <div class="field" style="display: inline-block; margin-right: 1em;">
          <div class="ui radio checkbox">
            <input type="radio" name="r" tabindex="0" value="0">
            <label>0</label>
          </div>
        </div>
        <div class="field" style="display: inline-block; margin-right: 1em;">
          <div class="ui radio checkbox">
            <input type="radio" name="r" tabindex="0" value="1">
            <label>1</label>
          </div>
        </div>
        <div class="field" style="display: inline-block; margin-right: 1em;">
          <div class="ui radio checkbox">
            <input type="radio" name="r" tabindex="0" value="2">
            <label>2</label>
          </div>
        </div>
        <div class="field" style="display: inline-block; margin-right: 1em;">
          <div class="ui radio checkbox">
            <input type="radio" name="r" tabindex="0" checked value="3">
            <label>3</label>
          </div>
        </div>
        <div class="field" style="display: inline-block;">
          <div class="ui radio checkbox">
            <input type="radio" name="r" tabindex="0" value="4">
            <label>4</label>
          </div>
        </div>
        <button class="ui fluid large green submit button" style="text-align: center;" type="submit"
                @click="submit">
          Submit
        </button>
      </div>
      <div class="ui error message"
           style="border: 1px solid #E0B4B4; margin-bottom: 14px; box-shadow: rgba(159, 58, 56, 0.12) 0 2px 4px 0, rgba(159, 58, 56, 0.15) 0 2px 10px 0;"></div>
    </form>
    <div class="ui raised black segment adaptive">
      <h2 class="ui header" style="text-align: center;">History of results</h2>
      <div class="ui error message" style="margin-bottom: 0;">
        <ul class="list">
          <li>Nothing to show: history is empty!</li>
        </ul>
      </div>
      <table class="ui celled unstackable center aligned table adaptive" style="display: none; margin-top: 14px;">
        <thead>
        <tr>
          <th>X</th>
          <th>Y</th>
          <th>R</th>
          <th>Hit</th>
          <th>Execute Time</th>
        </tr>
        </thead>
        <tbody>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>
import $ from 'jquery';
import axios from 'axios';

export default {
  methods: {
    logout() {
      localStorage.removeItem('jwt');
      this.$router.push('auth');
    },
    getPoints() {
      let router = this.$router;
      let drawPoint = this.drawPoint;
      axios.get('/api/points/get', {
        headers: {'Authorization': 'Bearer ' + localStorage.getItem('jwt')}
      }).then(response => {
        if (response.data.length > 0) {
          $('tbody').html('');
          response.data.forEach(e => {
            let tr = '<tr><td>' + e.x + '</td><td>' + e.y + '</td><td>' + e.r + '</td><td class=' + (e.inArea === true ? '"positive"><i class="icon check">' : '"negative"><i class="icon close">') + '</i></td><td>' + e.date + '</td></tr>';
            $('tbody').append(tr);
            drawPoint(e.x, e.y, document.getElementById('canvas'), document.getElementById('canvas').getContext('2d'),e.inArea);
          });
          $('table').css('display', 'table');
          $('.black.segment .error.message').css('display', 'none');
        }
      }).catch(function () {
        localStorage.removeItem('jwt');
        router.push('auth');
      });
    },
    submit() {
      this.addPoint(false, $('input[name=x]:checked').val(), $('input[name=y]').val(), $('input[name=r]:checked').val());
    },
    addPoint(auto, x, y, r) {
      let getPoints = this.getPoints;
      let router = this.$router;
      setTimeout(async function () {
        let button = $('.green.button');
        button.addClass('loading');
        if (auto === true || $('.ui.form').hasClass('success')) {
          await axios.post('/api/points/add', {
            x,
            y,
            r,
          }, {
            headers: {'Authorization': 'Bearer ' + localStorage.getItem('jwt')}
          }).then(function () {
            getPoints();
          }).catch(function () {
            localStorage.removeItem('jwt');
            router.push('auth');
          });
        }
        button.removeClass('loading');
      }, 1);
    },
    configureCanvas(canvas, context) {
      canvas.width = getComputedStyle(canvas).width.split('px')[0]; // получаем ширину canvas из его css ширины
      canvas.height = getComputedStyle(canvas).height.split('px')[0]; // получаем длину canvas из его css ширины
      canvas.width = Math.ceil(canvas.width * 4); // увеличиваем в 4 раза
      canvas.height = Math.ceil(canvas.height * 4); // увеличиваем в 4 раза
      context.scale(canvas.width / 264, canvas.height / 264); // увеличиваем масштаб, получаем более хорошее качество
    },
    drawArea(r, canvas, context) {
      context.clearRect(0, 0, canvas.width, canvas.height); // очистка перед новой отрисовкой

      context.fillStyle = 'black';
      context.lineWidth = 1;
      context.beginPath(); // оси
      context.moveTo(132.5, 0);
      context.lineTo(132.5, 264);
      context.moveTo(128, 6);
      context.lineTo(132.5, 0);
      context.moveTo(137, 6);
      context.lineTo(132.5, 0);
      context.moveTo(0, 132.5);
      context.lineTo(264, 132.5);
      context.moveTo(258, 137);
      context.lineTo(264, 132.5);
      context.moveTo(258, 128);
      context.lineTo(264, 132.5);
      context.stroke();

      context.font = '1em Lato'; // подписи осей
      context.fillText('Y', 120, 11);
      context.fillText('X', 255, 148);

      context.fillStyle = '#2185D0';
      if (r > 0) {
        context.fillRect(132.5 - r * 18 - 1, 132.5 - r * 18 * 2 - 1.5, r * 18 + 1, r * 18 * 2 + 1); // прямоугольник

        context.beginPath(); // треугольник
        context.moveTo(133, 132);
        context.lineTo(133 + r * 18 * 2 + 1.5, 132);
        context.lineTo(133, 132 - r * 18 - 1);
        context.lineTo(133, 132);
        context.fill();

        context.beginPath(); // круг
        context.arc(133, 133, r * 18 + 1, 0, 0.5 * Math.PI, false);
        context.lineTo(133, 133);
        context.fill();
      } else if (r < 0) {
        context.fillRect(134 - r * 18, 134 - r * 18 * 2, r * 18 - 1, r * 18 * 2 - 1); // прямоугольник

        context.beginPath(); // треугольник
        context.moveTo(132, 133);
        context.lineTo(132 + r * 18 * 2 - 1, 133);
        context.lineTo(132, 134 - r * 18);
        context.lineTo(132, 133);
        context.fill();

        context.beginPath(); // круг
        context.arc(132, 132, Math.abs(r) * 18 + 1, Math.PI, 1.5 * Math.PI, false);
        context.lineTo(132, 132);
        context.fill();
      }

      for (let i = 1; i <= 6; i++) {
        context.beginPath();
        context.moveTo(132.5 + i * 18 + 1, 130); // насечки по x вправо
        context.lineTo(132.5 + i * 18 + 1, 135);
        context.moveTo(132.5 - i * 18 - 1, 130); // насечки по x влево
        context.lineTo(132.5 - i * 18 - 1, 135);
        context.moveTo(130, 132.5 + i * 18 + 1); // насечки по y вниз
        context.lineTo(135, 132.5 + i * 18 + 1);
        context.moveTo(130, 132.5 - i * 18 - 1); // насечки по y вверх
        context.lineTo(135, 132.5 - i * 18 - 1);
        context.stroke();
      }

      context.fillStyle = "black";
      if (r !== '0') {
        context.fillText('R', 120, 132.5 - Math.abs(r) * 18 * 2 + 2); // R по y
        context.fillText('R', 120, 132.5 + Math.abs(r) * 18 * 2 + 4);
        context.fillText('R', 132.5 - Math.abs(r) * 18 * 2 - 5, 148); // R по x
        context.fillText('R', 132.5 + Math.abs(r) * 18 * 2 - 3, 148);
      } else {
        context.fillText('R', 122, 145); // R = 0
      }
      if (Math.abs(r) > 1) {
        context.fillText('0.5R', 120 - 19, 132.5 - Math.abs(r) * 18 + 2); // 0.5R по y
        context.fillText('0.5R', 120 - 19, 132.5 + Math.abs(r) * 18 + 4);
        context.fillText('0.5R', 132.5 - Math.abs(r) * 18 - 10, 148); // 0.5R по x
        context.fillText('0.5R', 132.5 + Math.abs(r) * 18 - 8, 148);
      }
    },
    drawPoint(x, y, canvas, context, inArea) {
      let dotX;
      let dotY;
      if (x === 0) {
        dotX = 130.4;
      } else if (x > 0) {
        dotX = x * 36 + 131.4;
      } else {
        dotX = x * 36 + 129.4;
      }
      if (y === 0) {
        dotY = 133.4;
      } else if (y > 0) {
        dotY = -y * 36 + 132.4;
      } else {
        dotY = -y * 36 + 134.4;
      }
      context.fillStyle = '#FF0000';
      if (inArea) {
        context.fillStyle = '#00FF00';
      }
      context.font = '40px Lato';
      context.fillText(".", dotX, dotY);
    }
  },
  mounted() {
    if (localStorage.getItem('jwt') == null) {
      this.$router.push('auth');
    } else {
      let canvas = document.getElementById('canvas');
      let context = canvas.getContext('2d');
      let configureCanvas = this.configureCanvas;
      let addPoint = this.addPoint;
      let getPoints = this.getPoints;
      let drawArea = this.drawArea;
      canvas.addEventListener('click', function (e) {
        if (canvas.width !== Math.ceil(4 * getComputedStyle(canvas).width.split('px')[0])) {
          configureCanvas(canvas, context);
          drawArea($('input[name=r]:checked').val(), canvas, context);
        }

        let diffX = e.clientX - e.target.getBoundingClientRect().left;
        let diffY = e.clientY - e.target.getBoundingClientRect().top;
        let x, y;
        if (canvas.width / 4 === 264) {
          x = Number(((diffX - 132) / 36).toFixed(1));
          y = Number(((diffY - 132) / -36).toFixed(1));
        } else {
          x = Number(((diffX - 95) / 26 - 0.06).toFixed(1));
          y = Number(((diffY - 95) / -26 + 0.06).toFixed(1));
        }

        addPoint(true, x, y, $('input[name=r]:checked').val());
      });
      document.querySelectorAll('input[name=r]').forEach(radio => {
        radio.onclick = function () {
          drawArea(radio.value, canvas, context);
          getPoints();
        };
      });
      configureCanvas(canvas, context);
      drawArea($('input[name=r]:checked').val(), canvas, context);
      getPoints();
    }
  }
}
</script>