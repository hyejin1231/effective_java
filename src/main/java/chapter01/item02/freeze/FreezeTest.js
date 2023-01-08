'use strict'; // 이거 선언해줘야 freeze 할 수 있음

var hyejin = {
    'name' : 'Hyejin',
    'age' : 26
}

Object.freeze(hyejin); // 프로퍼티를 더이상 수정하거나 삭제하거나 할 수 없음

hyejin.hobby = ['독서'] // 프리징을 하면 여기서 에러가 날 것: Cannot add property hobby, object is not extensible
hyejin.hobby.push('운동')


console.log(hyejin.hobby);
