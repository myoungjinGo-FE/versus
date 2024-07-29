<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core"  prefix="c" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <style>
        body {
            display: flex;
            flex-direction: column;
            align-items: center;
            min-height: 100vh;
            margin: 0;
        }
        .container {
            display: flex;
            justify-content: center;
            align-items: center;
            flex-wrap: wrap;
        }
        img {
            width: 200px;
            height: 200px;
        }
        .snack {
            position: relative;
            display: flex;
            flex-direction: column;
            align-items: center;
            margin: 10px;
            transition: order 0.3s ease;
        }
        .snack.invalid {
            opacity: 0.7;
        }
    </style>
</head>
<body>
time to choice
<div class="container">
    <c:forEach items="${versus.getSnacks()}" var="snack">
        <div class="snack${snack.getId() != 1 ? ' invalid' : ''}" id="snack-${snack.getId()}">
            <img src="${snack.getImageUrl()}">
            <div>${snack.getName()}</div>
        </div>
    </c:forEach>
</div>

<script type="text/javascript">
    const snacks = document.querySelectorAll('.snack');
    const container = document.querySelector('.container');

    let invalidWarningShown = false;
    let originalOrder = Array.from(snacks).map(snack => snack.style.order);

    snacks.forEach((snack, index) => {
        snack.style.order = index;

        snack.addEventListener('mouseenter', () => {
            if (snack.classList.contains('invalid')) {
                const validSnack = Array.from(snacks).find(s => !s.classList.contains('invalid'));
                if (validSnack) {
                    const tempOrder = snack.style.order;
                    snack.style.order = validSnack.style.order;
                    validSnack.style.order = tempOrder;

                }
                console.log("!!")
            } else {
                console.log("??")
            }
        });

        snack.addEventListener('mouseleave', () => {
            snacks.forEach((s, i) => {
                s.style.order = i;
            });
        });

        snack.addEventListener('click', () => {
            const snackId = snack.id.split('-')[1];
            if (snack.classList.contains('invalid')) {
                if (!invalidWarningShown) {
                    alert('잘못 선택한거 같습니다.');
                    invalidWarningShown = true;
                    return;
                }
            }

            fetch(`/versus/${versus.getVersusId()}/vote`, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify({
                    userId: ${user.getUserId()},
                    snackId: snackId
                })
            }).then(response => {
                response.json().then(data => {
                    window.location.href = data.redirectUrl;
                });
            }).catch(error => {
                console.error('Error:', error);
                alert('오류가 발생했습니다.');
            });
        });
    });
</script>
</body>
</html>