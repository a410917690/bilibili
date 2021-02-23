define([
    'data',
    "getEl"
], function (data, getEl) {
    function Pages(obj) {
        Object.assign(this, {
            xbind: 0,//初始化下标
            oage: 5,//每页显示的个数
            selexb:[5,8,10,12]
        }, obj);
        this.Init();
    }

    Pages.prototype.Init = function () {
        this.xb = this.oage;
        this.pagenum = Math.ceil(data.length / this.xb);
        //pagenum求出分页器的个数
        this.rander();
        this.randeroption();
        this.randerinner();
        this.liclick();
        this.changeoption();
        this.leftandrights();
    }
    
    Pages.prototype.leftandrights=function(){
        var that = this;
        this.right.onclick=function(){
            that.xbind++;
            if (that.olf.querySelector(".active")) {
                that.olf.querySelector(".active").classList.remove("active");
            }
            if(that.xbind>that.olf.children.length-1)
            {
                that.xbind=0;
            }
            that.olf.children[that.xbind].classList.add("active");
            that.randerinner();
        }
        this.left.onclick=function(){
            that.xbind--;
            if (that.olf.querySelector(".active")) {
                that.olf.querySelector(".active").classList.remove("active");
            }
            if(that.xbind<0)
            {
                that.xbind=that.olf.children.length-1;
            }
            that.olf.children[that.xbind].classList.add("active");
            that.randerinner();
        }

        
    }
    Pages.prototype.randeroption = function () {
        this.sele.innerHTML += this.selexb.map(function (item) {
            return `<option value="${item}">${item}</option>`
        }).join("");
    }

    Pages.prototype.changeoption = function () {
        var that = this;
        this.sele.addEventListener("change", function () {
            that.xbind = 0;
            that.oage = this.value * 1;
            that.pagenum = Math.ceil(data.length / that.oage);
            that.rander();
            that.randerinner();
        })
    }
    Pages.prototype.rander = function () {
        var str = "";
        for (var i = 0; i < this.pagenum; i++) {
            str += `<li ind="${i}" class="${this.xbind == i ? "active" : ""}">${i + 1}</li>`
        }
        this.olf.innerHTML = str;
    }

    Pages.prototype.randerinner = function () {
        //直接截取
        var bigin = this.oage * this.xbind,//获取截取开始下标 初始下标乘页面内的渲染个数
            overs = (this.xbind + 1) * this.oage
        var slicxb = data.slice(bigin, overs);
        var str = "";
        str += slicxb.map(function (item) {
            return `<li><dl>
                            <dt><img src="./img/${item.img}" alt=""></dt>
                            <dd>${item.name}</dd>
                        </dl>
                    </li>`
        }).join("");
        this.ulf.innerHTML = str;
    }

    Pages.prototype.liclick = function () {
        var that = this;
        this.olf.addEventListener("click", function (e) {
            var tar = e.target;
            if (tar.nodeName == "LI") {
                if (that.olf.querySelector(".active")) {
                    that.olf.querySelector(".active").classList.remove("active");
                }
                tar.classList.add("active");
                that.xbind = tar.getAttribute("ind") * 1;
                that.randerinner();
            }
        })
    }
    return Pages;
});
