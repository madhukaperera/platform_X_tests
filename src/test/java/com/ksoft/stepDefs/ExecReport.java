package com.ksoft.stepDefs;

public class ExecReport
{
    static String processedExecReport;
    static String receivedExecReport;

    public ExecReport()
    {

    }

    public static String getProcessedExecReport()
    {
        ExecReport.processedExecReport = ExecReport.receivedExecReport;
        return processedExecReport;
    }

    public static void setProcessedExecReport(String processedExecReport) {
        ExecReport.processedExecReport = processedExecReport;
    }

    public static String getReceivedExecReport() {
        return receivedExecReport;
    }

    public static void setReceivedExecReport(String receivedExecReport) {
        ExecReport.receivedExecReport = receivedExecReport;
        System.out.println("ExecutionReport Received Successfully/------------/"+ receivedExecReport+"\n");
    }
}
