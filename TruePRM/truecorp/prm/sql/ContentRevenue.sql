insertPostPaidSumContentRevenue{
                INSERT INTO SUM_CONTENT_REVENUE (TYPE_OF_CALL_IND,COMPANY_CODE,SERVICE_TYPE,DIRECTION,ACC_STAT_CODE,CONTENT_CD,CALL_DATE,SHORT_CODE,SERVICE_ID 
                ,CP_APP_KEY,ATB4_IND,RBT_DESCRIPTION,FEATURE_CD,DISCOUNT_GROUP_CD,SHARING_RATE,DURATION,AMT,DATE_OF_ADJUST,FLAG 
                ,PROCESS_DATE,COMPLETE_DATE_ADJUST,STATUS_ADJ_RBT,PARAM_DATE,NUM_OF_EVENTS, 
                SYS_CREATION_DATE,DL_SERVICE_CODE,INV_FLAG) 
                select 
                TYPE_OF_CALL_IND,COMPANY_CODE,SERVICE_TYPE,DIRECTION,ACC_STAT_CODE,CONTENT_CD,CALL_DATE,SHORT_CODE,SERVICE_ID, 
                ' ',ATB4_IND,RBT_DESCRIPTION,FEATURE_CD,DISCOUNT_GROUP_CD,SHARING_RATE,sum(DURATION),sum(AMT), 
                to_date($sysDate,'YYYYMMDDHH24MISS'),FLAG,to_date($sysDate,'YYYYMMDDHH24MISS'), 
                COMPLETE_DATE_ADJUST,STATUS_ADJ_RBT,PARAM_DATE||to_char(INV_STATUS_DATE,'YYYYMM'), 
                COUNT(PARAM_DATE),to_date($sysDate,'YYYYMMDDHH24MISS'),'     ',INV_FLAG 
                from $tableName 
                where 
                TYPE_OF_CALL_IND='Postpaid' 
                AND (call_date >= TO_DATE( ? ,'yyyymmdd') AND call_date <= TO_DATE( ? ,'yyyymmdd') )  
                AND INV_FLAG='C' 
                AND SHARING_RATE !='0' 
                AND ACC_STAT_CODE='L' 
                AND AMT <> 0 
                AND COMPANY_CODE in ('RM','RF') 
                AND  (((INV_STATUS_DATE = TO_DATE( ? ,'yyyymm') AND inv_flag = 'C') 
                OR ((INV_STATUS_DATE >= TO_DATE( ? ,'yyyymm') AND INV_STATUS_DATE <= TO_DATE( ? ,'yyyymm')) AND inv_flag = 'C')AND flag <> 'P')) 

                group by 
                TYPE_OF_CALL_IND,COMPANY_CODE,SERVICE_TYPE,DIRECTION,ACC_STAT_CODE,CONTENT_CD,CALL_DATE,SHORT_CODE,SERVICE_ID, 
                ATB4_IND,RBT_DESCRIPTION,FEATURE_CD,DISCOUNT_GROUP_CD, 
                SHARING_RATE,to_date($sysDate,'YYYYMMDDHH24MISS'),FLAG,COMPLETE_DATE_ADJUST,STATUS_ADJ_RBT, 
                PARAM_DATE||to_char(INV_STATUS_DATE,'YYYYMM'),INV_FLAG

}

updateFlagPostPaidContentRevenue{

                
                update $tableName  
                set flag = 'P' ,sys_update_date = sysdate 
                where 
                TYPE_OF_CALL_IND='Postpaid' 
                AND (call_date >= TO_DATE(?,'yyyymmdd') AND call_date <= TO_DATE(?,'yyyymmdd')) 
                AND INV_FLAG='C' 
                AND SHARING_RATE !='0' 
                AND ACC_STAT_CODE='L' 
                AND COMPANY_CODE in ('RM','RF') 
                AND AMT > 0 
                AND  (((INV_STATUS_DATE = TO_DATE( ? ,'yyyymm') AND inv_flag = 'C')  
                OR ((INV_STATUS_DATE >= TO_DATE(?,'yyyymm') AND INV_STATUS_DATE <= TO_DATE(?,'yyyymm')) AND inv_flag = 'C')AND flag <> 'P'))

}

insertPrepaidSumContentRevenue{

               INSERT INTO SUM_CONTENT_REVENUE (TYPE_OF_CALL_IND,COMPANY_CODE,SERVICE_TYPE,DIRECTION,ACC_STAT_CODE,CONTENT_CD,CALL_DATE, 
               SHORT_CODE,SERVICE_ID,CP_APP_KEY,ATB4_IND,RBT_DESCRIPTION,FEATURE_CD,DISCOUNT_GROUP_CD,SHARING_RATE,DURATION,AMT,DATE_OF_ADJUST 
               ,FLAG,PROCESS_DATE,COMPLETE_DATE_ADJUST,STATUS_ADJ_RBT,PARAM_DATE,NUM_OF_EVENTS,SYS_CREATION_DATE,DL_SERVICE_CODE,INV_FLAG) 
               select 
               TYPE_OF_CALL_IND,COMPANY_CODE,SERVICE_TYPE,DIRECTION,ACC_STAT_CODE,CONTENT_CD,CALL_DATE,SHORT_CODE,SERVICE_ID,' ', 
               ATB4_IND,RBT_DESCRIPTION,FEATURE_CD,' ', 
               SHARING_RATE,sum(DURATION),sum(AMT),to_date($sysdatetime,'YYYYMMDDHH24MISS'), 
               FLAG,to_date($sysdatetime,'YYYYMMDDHH24MISS'),COMPLETE_DATE_ADJUST,STATUS_ADJ_RBT, 
               to_date($sysdatetime,'YYYYMMDDHH24MISS'),COUNT(sharing_rate),to_date($sysdatetime,'YYYYMMDDHH24MISS'),'     ',INV_FLAG 
               from $tableName 
               where 
               TYPE_OF_CALL_IND='Prepaid' 
               AND (call_date >= TO_DATE(?,'yyyymmdd') AND call_date <= TO_DATE(?,'yyyymmdd')) 
               AND SHARING_RATE !='0' 
               AND ACC_STAT_CODE = 'L' 
               AND AMT > 0 
               AND COMPANY_CODE in ('RM','RF') 
               group by 
               TYPE_OF_CALL_IND,COMPANY_CODE,SERVICE_TYPE,DIRECTION,ACC_STAT_CODE,CONTENT_CD,CALL_DATE,SHORT_CODE,SERVICE_ID,ATB4_IND, 
               RBT_DESCRIPTION,FEATURE_CD,DISCOUNT_GROUP_CD,SHARING_RATE,to_date($sysdatetime,'YYYYMMDDHH24MISS'), 
               FLAG,COMPLETE_DATE_ADJUST,STATUS_ADJ_RBT,INV_FLAG

}

updatePrepaidContentRevenue{
                update $tableName  
                set flag = 'P' ,sys_update_date = sysDate
                where 
                TYPE_OF_CALL_IND='Prepaid' 
                AND (call_date >= TO_DATE(?,'yyyymmdd') AND call_date <= TO_DATE(?,'yyyymmdd'))
                AND SHARING_RATE !='0' 
                AND ACC_STAT_CODE='L' 
                AND AMT > 0 
                AND COMPANY_CODE in ('RM','RF') 
}

insertAdjustmentSumContentRevenue{

                INSERT INTO SUM_CONTENT_REVENUE (TYPE_OF_CALL_IND,COMPANY_CODE,SERVICE_TYPE,DIRECTION,ACC_STAT_CODE,CONTENT_CD,CALL_DATE,SHORT_CODE, 
                SERVICE_ID,CP_APP_KEY,ATB4_IND,RBT_DESCRIPTION,FEATURE_CD,DISCOUNT_GROUP_CD,SHARING_RATE,DURATION,AMT,DATE_OF_ADJUST, 
                FLAG,COMPLETE_DATE_ADJUST,STATUS_ADJ_RBT,PARAM_DATE,NUM_OF_EVENTS,SYS_CREATION_DATE,DL_SERVICE_CODE,INV_FLAG) 
                select 
                TYPE_OF_CALL_IND,COMPANY_CODE,SERVICE_TYPE,DIRECTION,ACC_STAT_CODE,CONTENT_CD,CALL_DATE,SHORT_CODE,SERVICE_ID,CP_APP_KEY,ATB4_IND, 
                RBT_DESCRIPTION,FEATURE_CD,DISCOUNT_GROUP_CD,SHARING_RATE,sum(DURATION),sum(AMT),DATE_OF_ADJUST,FLAG,COMPLETE_DATE_ADJUST,STATUS_ADJ_RBT,PARAM_DATE||'      ',SUM(NO_ADJ),to_date($sysdatetime,'YYYYMMDDHH24MISS'), 
                '     ',INV_FLAG 
                from $tableName
                where 
                DATE_OF_ADJUST >=   to_date(?,'yyyymmdd') AND DATE_OF_ADJUST <= to_date(?,'yyyymmdd') 
                AND TYPE_OF_CALL_IND in ('Adj.Post.','Adj.Prep') 
                AND SHARING_RATE !='0' 
                group by 
                TYPE_OF_CALL_IND,COMPANY_CODE,SERVICE_TYPE,DIRECTION,ACC_STAT_CODE,CONTENT_CD,CALL_DATE, 
                SHORT_CODE,SERVICE_ID,CP_APP_KEY,ATB4_IND,RBT_DESCRIPTION,FEATURE_CD, 
                DISCOUNT_GROUP_CD,SHARING_RATE,DATE_OF_ADJUST, 
                FLAG,COMPLETE_DATE_ADJUST,STATUS_ADJ_RBT,PARAM_DATE||'      ',INV_FLAG

}