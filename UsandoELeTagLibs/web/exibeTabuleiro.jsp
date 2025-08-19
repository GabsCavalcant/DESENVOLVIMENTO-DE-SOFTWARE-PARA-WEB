<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
    <head>
        <title>Testes Tags JSTL</title>
        <meta charset="UTF-8">
        <meta name="viewport"
              content="width=device-width, initial-scale=1.0">

        <style>
            .celula {
                width: 20px;
                height: 20px;
            }

            .linhaImpar {
                background: #eeeeee;
            }
        </style>

    </head>
    <body>
        <div>
            <table>
                <c:forEach begin="1" end="${param.linhas}" varStatus="i">
                    <tr>
                        <c:forEach begin="1" end="${param.colunas}" varStatus="j">
                            <c:choose>
                                <c:when test = "${ (i.count + j.count) % 2 == 0}"> 
                                    <td class ="celula" style="background-color: ${param.cor1}"></td>
                                </c:when>
                                <c:otherwise>
                                    <td class ="celula" style="background-color: ${param.cor2}"></td>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
