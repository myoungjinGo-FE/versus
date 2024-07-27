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
</head>
<body>
    <style>
         img {
            width: 200px;
            height: 200px;
        }
    </style>
    time to choice
    <c:forEach items="${versus.getSnacks()}" var="snack">
        <div class="snack"  id="${snack.getId()}" >
            <img src="${snack.getImageUrl()}" >
            <div>${snack.getName()}</div>
        </div>
    </c:forEach>

    <script type="text/javascript">
        const snacks = document.querySelectorAll('.snack');

        snacks.forEach(snack => {
            snack.addEventListener('click', () => {
                const snackId = snack.id;

                // Fetch API를 사용하여 POST 요청 보내기
                fetch(`/versus/${versus.getVersusId()}/vote`, {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json',
                    },
                    body: JSON.stringify({
                        userId: ${user.getUserId()},
                        snackId: snackId
                    })
                })
                    .then(response => {
                        if (response.ok) {
                            alert('투표가 성공적으로 등록되었습니다!');
                        } else {
                            alert('투표 등록에 실패했습니다.');
                        }
                    })
                    .catch(error => {
                        console.error('Error:', error);
                        alert('오류가 발생했습니다.');
                    });
            });
        });
    </script>

</body>
</html>
