-- Exercises 

--     1. User Upcoming Events 
--     Show a list of all upcoming events a user is registered for in their city, sorted by date. 

        SELECT u.user_id,u.full_name,e.title,e.start_date from Users u 
                    JOIN Registrations r ON u.user_id = r.user_id 
                    JOIN Events e ON r.event_id = e.event_id 
                    where u.city = e.city AND e.status = 'upcoming' ORDER BY e.start_date;

    
    -- *2. Top Rated Events 
    -- Identify events with the highest average rating, considering only those that have received at 
    -- least 10 feedback submissions. 

        -- SELECT e.event_id,e.title,m.maxi
        --     from (SELECT MAX(f.avrg) as maxi from (SELECT Avg(f.rating) as avrg from feedback f GROUp BY event_id) x ) m
        --     Having (SELECT COUNT(*) from feedback GROUP BY ) >10

    -- 3. Inactive Users 
    -- Retrieve users who have not registered for any events in the last 90 days.

        SELECT u.user_id,u.full_name from users u 
            LEFT JOIN Registrations r ON u.user_id = r.user_id AND r.registration_date >= DATEADD(day, -90, CAST(GETDATE() AS date))
            where r.user_id IS null ;

    -- 4. Peak Session Hours 
    --     Count how many sessions are scheduled between 10 AM to 12 PM for each event.

        SELECT e.event_id,e.title,COUNT(s.event_id) as session_count FROM Events e 
            JOIN Sessions s ON e.event_id = s.event_id 
            where HOUR(s.start_time) BETWEEN 10 AND 12
            GROUP BY e.event_id;

    -- 5. Most Active Cities 
    --     List the top 5 cities with the highest number of distinct user registrations.

        SELECT e.city,COUNT(DISTINCT r.user_id) as total_users FROM Events 
            JOIN Registrations r ON e.event_id=r.event_id
            GROUP BY e.city ORDER BY total_users DESC 
            LIMIT 5;

    -- 6. Event Resource Summary 
    --     Generate a report showing the number of resources (PDFs, images, links) uploaded for each event.

        SELECT event_id,title,COUNT(event_id) as count Resources 
            GROUP BY event_id
            ORDER BY event_id;

    -- 7. Low Feedback Alerts 
    -- List all users who gave feedback with a rating less than 3, along with their comments and associated event names. 

        SELECT u.user_id,u.full_name,e.title,f.comments,f.rating FROM Users u  
            JOIN Feedback f ON u.user_id = f.user_id
            JOIN Events e ON e.event_id = f.event_id
            WHERE f.rating < 3;

    -- 8. Sessions per Upcoming Event
    --  Display all upcoming events with the count of sessions scheduled for them.

        SELECT e.event_id,e.title,COUNT(s.event_id) as total_sessions FROM Events e  
            LEFT JOIN Sessions s ON e.event_id = s.event_id
            WHERE e.status = 'upcoming' 
            GROUP BY e.event_id,e.title;

    -- 9. Organizer Event Summary 
    -- For each event organizer, show the number of events created and their current status (upcoming, completed, cancelled). 
        SELECT u.user_id,u.full_name,e.status,COUNT(*) as total_events FROM Users u  
            JOIN Events e ON u.user_id = e.organizer_id
            GROUP BY  u.user_id,u.full_name,e.status;

    -- 10. Feedback Gap 
    -- Identify events that had registrations but received no feedback at all.
        SELECT DISTINCT e.event_id,e.title FROM Events e  
            JOIN Registrations r ON e.event_id = r.event_id
            LEFT JOIN Feedback f ON e.event_id = f.event_d
            WHERE f.feedback-id IS NULL;
