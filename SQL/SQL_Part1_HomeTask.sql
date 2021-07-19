#  Part 1

#1) Update the Employees table, so it contains the HireDate values from 2017 till the current (2021) year.
UPDATE
    employees e
SET
    e.HireDate = ADDDATE(HireDate, INTERVAL 28 YEAR); 

#2) Delete records from the Products table which weren't ordered.
DELETE
FROM
    products
WHERE
    ProductID NOT IN (
        SELECT
            od.ProductID
        FROM
            `order details` od
    );

#3) Get the list of data about employees: First Name, Last Name, Title, Hire Date who was hired this year (2021).
SELECT
    FirstName,
    LastName,
    Title,
    HireDate
FROM
    employees e
WHERE
    YEAR (HireDate) = YEAR (
        current_date()
    );

#4) Find quantity of employees in each department. Note: Departments is the same as a title in the Employees table 
SELECT
    e2.TerritoryID,
    COUNT(e2.EmployeeID)
FROM
    employeeterritories e2
GROUP BY
    e2.TerritoryID;

#5) Get the list of suppliers, which are located in USA and have a specified region.
SELECT
    *
FROM
    suppliers s
WHERE
    s.Country = 'USA'
    AND s.Region IS NOT NULL;

/*6) Get the amount of products that were delivered by each supplier (company), 
which have a discount from the Unit Price more than 10%. 
Where record are represented from the biggest to lowest discount. */
SELECT
    p.ProductID,
    count(*) 'amount_of_products',
    od.Discount
FROM
    `order details` od
INNER JOIN suppliers s
INNER JOIN products p 
ON
    od.ProductID = p.ProductID
    AND od.Discount > 0.1
    AND s.SupplierID = p.SupplierID
GROUP BY
    p.ProductID
ORDER BY
    od.Discount DESC ;

#7) Get the top five product categories with the list of the most buyable products in Germany.
SELECT
    p.CategoryID,
    p.ReorderLevel,
    o.ShipCountry
FROM
    products p
INNER JOIN orders o
INNER JOIN `order details` od 
ON
    p.ProductID = od.ProductID
    AND o.ShipCountry = 'Germany'
GROUP BY
    p.CategoryID
ORDER BY
    p.ReorderLevel DESC
LIMIT 5;

#8) Get the First Name, Last Name and Title of Managers and their subordinates.
SELECT
    e.FirstName ,
    e.LastName ,
    e.Title,
    e2.FirstName ,
    e2.LastName ,
    e2.Title
FROM
    employees e
INNER JOIN employees e2 
ON
    e.EmployeeID = e2.ReportsTo
GROUP BY
    e2.EmployeeID
ORDER BY
    e.FirstName;

/*9) Get the Firts Name, Lastn Name, Title of Sales who has the least amount of orders. 
(Amount of sold products should be also in the result set).*/
SELECT
    e.FirstName,
    e.LastName,
    e.Title,
    COUNT(o.OrderID) 'amount_of_sales'
FROM
    orders o
INNER JOIN employees e 
ON
    o.EmployeeID = e.EmployeeID
GROUP BY
    e.EmployeeID
ORDER BY
    COUNT(o.OrderID)
LIMIT 1;
