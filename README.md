# Test

CREATE TABLE employees (
    employee_id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    department VARCHAR(50) NOT NULL,
    salary DECIMAL(10, 2) NOT NULL,
    hire_date DATE NOT NULL
);

CREATE TABLE job_history (
    job_id SERIAL PRIMARY KEY,
    employee_id INT REFERENCES employees(employee_id) ON DELETE CASCADE,
    job_title VARCHAR(100) NOT NULL,
    promotion_date DATE,
    previous_salary DECIMAL(10, 2),
    start_date DATE,
    end_date DATE,
    promotions VARCHAR(100)
);

CREATE TABLE performance_evaluations (
    evaluation_id SERIAL PRIMARY KEY,
    employee_id INT REFERENCES employees(employee_id) ON DELETE CASCADE,
    year INT NOT NULL,
    rating INT NOT NULL CHECK (rating >= 1 AND rating <= 5),
    feedback TEXT
);

CREATE TABLE salary_trends (
    trend_id SERIAL PRIMARY KEY,
    employee_id INT REFERENCES employees(employee_id) ON DELETE CASCADE,
    year INT NOT NULL,
    salary DECIMAL(10, 2) NOT NULL
);

CREATE TABLE department_summary (
    department VARCHAR(50) PRIMARY KEY,
    total_employees INT NOT NULL
);


INSERT INTO public.job_history (employee_id, job_title, promotion_date, previous_salary, start_date, end_date, promotions) VALUES
(1, 'Software Engineer', '2021-06-01', 8500.00, '2020-01-01', '2021-05-31', 'Senior Software Engineer'),
(2, 'HR Specialist', '2021-04-01', 7000.00, '2019-03-15', '2021-03-15', NULL),
(3, 'Financial Analyst', '2022-06-01', 11000.00, '2018-05-22', '2022-05-22', 'Senior Financial Analyst'),
(4, 'System Administrator', '2022-02-01', 10000.00, '2021-07-10', '2022-01-10', 'Senior System Administrator'),
(5, 'HR Manager', '2022-01-01', 7000.00, '2020-09-15', '2021-12-31', 'Head of HR'),
(6, 'Senior Financial Analyst', '2021-11-01', 11500.00, '2017-11-01', '2021-10-31', 'Lead Financial Analyst'),
(7, 'IT Specialist', '2021-10-01', 9400.00, '2019-02-20', '2021-09-30', NULL),
(8, 'HR Coordinator', '2022-05-01', 7200.00, '2021-06-01', '2022-04-30', 'HR Manager'),
(9, 'Lead Financial Analyst', '2022-07-01', 13000.00, '2016-12-05', '2022-06-30', 'Finance Director'),
(10, 'Network Engineer', '2022-07-01', 9900.00, '2022-04-25', '2022-06-30', NULL);

INSERT INTO salary_trends (employee_id, year, salary) VALUES
(1, 2021, 9500.00),
(1, 2022, 10000.00),
(2, 2021, 7500.00),
(2, 2022, 7800.00),
(3, 2020, 12000.00),
(3, 2021, 12500.00),
(4, 2021, 11000.00),
(4, 2022, 11500.00),
(5, 2021, 7200.00),
(5, 2022, 7500.00),
(6, 2021, 12500.00),
(6, 2022, 13000.00),
(7, 2021, 9800.00),
(7, 2022, 10500.00),
(8, 2022, 7600.00),
(9, 2020, 14000.00),
(9, 2021, 14500.00),
(10, 2022, 10500.00);

INSERT INTO performance_evaluations (employee_id, year, rating, feedback) VALUES
(1, 2021, 4, 'Good performance, met expectations'),
(2, 2021, 3, 'Needs improvement in communication skills'),
(3, 2020, 5, 'Excellent performance, exceeded expectations'),
(4, 2022, 4, 'Solid performance with room for improvement'),
(5, 2022, 3, 'Performance met minimum expectations'),
(6, 2021, 4, 'Great financial analysis skills'),
(7, 2021, 5, 'Exceptional IT problem-solving abilities'),
(8, 2022, 3, 'Good coordination skills, needs more leadership'),
(9, 2020, 5, 'Consistently exceeds expectations in financial planning'),
(10, 2022, 4, 'Strong network administration, but needs to improve in team collaboration');

INSERT INTO employees (name, department, salary, hire_date) VALUES
('John Doe', 'IT', 9500.00, '2020-01-01'),
('Jane Smith', 'HR', 7500.00, '2019-03-15'),
('Emily Johnson', 'Finance', 12000.00, '2018-05-22'),
('Michael Brown', 'IT', 11000.00, '2021-07-10'),
('Sarah Davis', 'HR', 7200.00, '2020-09-15'),
('David Wilson', 'Finance', 12500.00, '2017-11-30'),
('James Lee', 'IT', 9800.00, '2019-02-20'),
('Linda Miller', 'HR', 7600.00, '2021-06-01'),
('Robert Taylor', 'Finance', 14000.00, '2016-12-05'),
('Jessica Anderson', 'IT', 10500.00, '2022-04-25');

INSERT INTO department_summary (department, total_employees) VALUES
('IT', 50),
('HR', 30),
('Finance', 40),
('Sales', 25),
('Marketing', 35),
('Engineering', 45),
('Customer Support', 20),
('Legal', 10),
('Operations', 60),
('R&D', 15);
