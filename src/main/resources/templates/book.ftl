<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
<div>
    <@l.logout />
</div>

<div>
    <form method="POST">
        <input type="text" name="name" placeholder="Name of the book" />
        <input type="text" name="author" placeholder="Author" />
        <input type="text" name="count" placeholder="Count" />
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button type="submit">add</button>
    </form>
</div>

<div>
    <form method="GET">
        <input type="text" name="filter" placeholder="Name.." value=${filter}>
        <button type="submit">find</button>
    </form>
</div>

<table>
    <th>
        <td>[name]</td>
        <td>[author]</td>
        <td>[count]</td>
    </th>
    <#list books as book>
    <tr>
        <td></td>
        <td>${book.name}</td>
        <td>${book.author}</td>
        <td>${book.count}</td>
    </tr>
    </#list>
</table>

</@c.page>