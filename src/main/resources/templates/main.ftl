<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
<div>
    <@l.logout />
</div>

<div>
    <form method="post">
        <input type="text" name="name" placeholder="Name of the book" />
        <input type="text" name="author" placeholder="Author" />
        <input type="text" name="count" placeholder="Count" />
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button type="submit">Add to catalog</button>
    </form>
</div>

<div><strong>Catalog:</strong></div>
<#list books as book>
<div>
    <b>Name: [${book.name}]</b>
    <b>Author: [${book.author}]</b>
    <b>Count: [${book.count}]</b>
    <b><a href>[+] Buy</a></b>
</div>
</div>
<#else>
Catalog is empty
</#list>

</@c.page>