<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
<h2><button type="submit"><a href="/login">Back</a></button>Add new user</h2>
<#if message??><p>${message}</#if>
<@l.login "/registration" />
</@c.page>